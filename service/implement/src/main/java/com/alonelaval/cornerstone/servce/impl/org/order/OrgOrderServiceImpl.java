package com.alonelaval.cornerstone.servce.impl.org.order;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.exception.ExceptionUtil;
import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.common.page.Page;
import com.alonelaval.common.snowflake.SnowflakeUidGenerator;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.order.OrgOrderDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.*;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.*;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.OrgOrderModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.OrgService;
import com.alonelaval.cornerstone.service.org.course.OrgCoursePeriodService;
import com.alonelaval.cornerstone.service.org.course.OrgCoursePlaceService;
import com.alonelaval.cornerstone.service.org.course.OrgCoursePriceService;
import com.alonelaval.cornerstone.service.org.course.OrgCourseService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeService;
import com.alonelaval.cornerstone.service.org.order.OrgOrderCourseCoachService;
import com.alonelaval.cornerstone.service.org.order.OrgOrderCoursePeriodService;
import com.alonelaval.cornerstone.service.org.order.OrgOrderCourseService;
import com.alonelaval.cornerstone.service.org.order.OrgOrderService;
import com.alonelaval.cornerstone.service.org.student.OrgStudentService;
import com.alonelaval.cornerstone.service.user.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgOrderService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgOrderServiceImpl extends AbstractBaseService<OrgOrder,Integer> implements OrgOrderService {
    @Autowired
    OrgOrderDao orgOrderDao;
    @Autowired
    OrgService orgService;
    @Autowired
    OrgCourseService orgCourseService;
    @Autowired
    OrgCoursePlaceService orgCoursePlaceService;
    @Autowired
    OrgCoursePriceService orgCoursePriceService;
    @Autowired
    OrgCoursePeriodService orgCoursePeriodService;
    @Autowired
    OrgOrderCourseCoachService orgOrderCourseCoachService;
    @Autowired
    UserStudentService userStudentService;
    @Autowired
    OrgStudentService orgStudentService;
    @Autowired
    OrgEmployeeService orgEmployeeService;
    @Autowired
    SnowflakeUidGenerator userOrderUidGenerator;
    @Autowired
    OrgOrderCourseService orderCourseService;
    @Autowired
    OrgOrderCoursePeriodService orgOrderCoursePeriodService;
    @Autowired
    UserService userService;
    @Autowired
    UserAddresseeService userAddresseeService;
    @Autowired
    UserInvoiceService  userInvoiceService;
    @Autowired
    OrderInvoiceRecordService orderInvoiceRecordService;
    @Override
    public Page<OrgOrder> findByModelAndPage(Model model, Page<OrgOrder> page) throws Exception {
        OrgOrderModel orgOrderModel = (OrgOrderModel) model;
        WhereBuilder builder = WhereBuilder.build();

        if(orgOrderModel.getState() == null ){
            builder.in(QOrgOrder.orgOrder.state,State.ENABLED,State.DISABLED);
        }else
        {
            builder.and(QOrgOrder.orgOrder.state.eq(orgOrderModel.getState()));
        }

        builder.and(QOrgOrder.orgOrder.userId,orgOrderModel.getUserId());
        builder.and(QOrgOrder.orgOrder.orderState,orgOrderModel.getOrderState());
        builder.startWith(QOrgOrder.orgOrder.userName,orgOrderModel.getUserName());
        builder.andBetweenNumber(QOrgOrder.orgOrder.totalPayAmount,orgOrderModel.getMinAmount(),orgOrderModel
                .getMaxAmount());
        builder.and(QOrgOrder.orgOrder.orgId,orgOrderModel.getOrgId());
        builder.and(QOrgOrder.orgOrder.dealNumber, orgOrderModel.getDealNumber());
        builder.andBetweenTime(QOrgOrder.orgOrder.orderTime,orgOrderModel.getBeginOrderDate(),
                orgOrderModel.getEndOrderDate());

        return orgOrderDao.findAllByPredicateAndPage(builder.predicate(),page);
    }

    @Override
    public OrgOrder add(Model model) throws Exception {
        OrgOrderModel orgOrderModel = (OrgOrderModel) model;
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();

        Optional<Org> optionalOrg  = orgService.findById(orgOrderModel.getOrgId());
        if(!optionalOrg.isPresent()){
            ExceptionUtil.throwServiceException(ExceptionType.ORG_NOT_FOUND);
        }
        Optional<OrgCourse> optionalOrgCourse = orgCourseService.findById(orgOrderModel.getCourseId());
        if(!optionalOrg.isPresent() || !optionalOrg.get().getOrgId().equals(optionalOrg.get().getOrgId())){
            ExceptionUtil.throwServiceException(ExceptionType.PARAM_ERROR);
        }
        Optional<UserStudent> userStudentOptional = Optional.empty();
        //用户选择了上课的学员
        if(orgOrderModel.getUserStudentId() != null){
            userStudentOptional= userStudentService.findById(orgOrderModel.getUserStudentId());
        }

        Optional<OrgEmployee> orgEmployeeOptional = orgEmployeeService.findById(orgOrderModel.getEmployeId());
        if(!orgEmployeeOptional.isPresent()){
            ExceptionUtil.throwServiceException(ExceptionType.PARAM_ERROR);
        }
        Optional<OrgCoursePrice> orgCoursePrice = orgCoursePriceService.findById(orgOrderModel.getCoursePriceId());
        if(!orgCoursePrice.isPresent()){
            ExceptionUtil.throwServiceException(ExceptionType.PARAM_ERROR);
        }
        Optional<OrgCoursePlace> orgCoursePlace = orgCoursePlaceService.findById(orgOrderModel.getCoursePlaceId());
        if(!orgCoursePrice.isPresent()){
            ExceptionUtil.throwServiceException(ExceptionType.PARAM_ERROR);
        }

        OrgOrder orgOrder = null;

        //C端用户下单
        if(orgOrderModel.getUserId() == null && userAdapter.getLoginType().equals(RoleOwnType.USER_ROLE)){
            orgOrder = addOrder(userAdapter.getUser(),orgOrderModel,optionalOrgCourse.get(),optionalOrg.get(),
                        orgCoursePrice.get(),orgCoursePlace.get(),userStudentOptional,orgEmployeeOptional);
        }
        //B端创建订单
        else{
            orgOrder =addOrder(userService.findById(orgOrderModel.getUserId()).get(),
                        orgOrderModel,optionalOrgCourse.get(),optionalOrg.get(),
                        orgCoursePrice.get(),orgCoursePlace.get()
                        ,userStudentOptional,orgEmployeeOptional);

        }

        return orgOrder;
    }


    private OrgOrder addOrder(User user,OrgOrderModel orgOrderModel,OrgCourse orgCourse,Org org,OrgCoursePrice
            orgCoursePrice,OrgCoursePlace orgCoursePlace, Optional<UserStudent> userStudentOptional,Optional<OrgEmployee>
            orgEmployeeOptional)throws Exception{
        OrgOrder orgOrder = OrgOrder.builder()
                .dealNumber(userOrderUidGenerator.getUID()+"")
                .remark(orgOrderModel.getRemark())
                .userId(user.getUserId())
                .userName(user.getUserRealName())
                .isInvoiced(IsInvoiced.NOT_INVOICE)
                .orgId(org.getOrgId())
                .orgName(org.getOrgName())
                .orderTime(LocalDateTime.now())
                .phone(user.getPhone())
                .totalPayAmount(orgCoursePrice.getPrice())
                .orderState(OrderState.NOT_PAID)
                .build();

        SetEntityProperties.getInstance().setProperties(orgOrder);

        orgOrder = add(orgOrder);

        Optional<OrgStudent> orgStudentOptional= Optional.empty();
        //指定了上课人
        if(userStudentOptional.isPresent()){
            orgStudentOptional = orgStudentService.findByUserStudentId(userStudentOptional.get().getUserStudentId());
        }
        //没有指定上课人，上课人为下单的用户
        else {
            orgStudentOptional = orgStudentService.findByUserStudentId(user.getUserId());
        }

        OrgStudent orgStudent = null;
        if(!orgStudentOptional.isPresent()){
            orgStudent = orgStudentService.addStudent(userStudentOptional.orElse(null),user,org);
        }
        else{
            orgStudent = orgStudentOptional.get();
            orgStudent.setTotalJoinNum(orgStudent.getTotalJoinNum() + 1);
            orgStudent.setCurrentCourseNum(orgStudent.getTotalJoinNum()+ 1);
            orgStudent = orgStudentService.update(orgStudent);
        }


        //添加课程信息
        OrgOrderCourse orderCourse = orderCourseService.addOrderCourse(orgCourse,orgOrder,orgStudent,
                user,orgCoursePrice,orgCoursePlace);

        //添加教练，如果没有选择教练，由系统排课时分配教练
        if(orgEmployeeOptional.isPresent()) {
            orgOrderCourseCoachService.addOrderCoach(orderCourse, orgEmployeeOptional.get(), user);
        }

        //添加上课时间，是否允许设置上课时间
        if(orgCourse.getIsSettingTime().equals(AllowUserSettingCourseTimeType.FALSE)) {
            orgOrderCoursePeriodService.addCoursePeriod(orderCourse,user);
        }else{
            orgOrderCoursePeriodService.addCoursePeriod(orgOrderModel.getCoursePeriodIds(),orderCourse,user);
        }

        //更新用户消费次数
        user.setConsumeCount(user.getConsumeCount() + 1 );
        userService.update(user);

        return  orgOrder;
    }



    @Override
    protected IBaseDao<OrgOrder,Integer> getBaseDao() {
        return orgOrderDao;
    }

    @Override
    public void invoiceOrder(List<Integer> orderIds, Integer invoiceId, Integer addresseeId) throws Exception {

        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        List<OrgOrder> orders = this.findAllByIds(orderIds);

        if(orderIds ==null || orderIds.isEmpty()){
            return ;
        }

        Integer userId = null;
        Integer orgId = null;
        for(OrgOrder orgOrder :orders){
            if(!orgOrder.getIsInvoiced().equals(IsInvoiced.NOT_INVOICE)){
                orderIds.remove(orgOrder.getOrgOrderId());
            }
            if(userId == null){
                userId = orgOrder.getUserId();
                continue;
            }
            if(orgId == null){
                orgId = orgOrder.getOrgId();
            }
            else if(!orgId.equals(orgOrder.getOrgOrderId())) {
                throw  new ServiceException(ExceptionType.OP_NOT_ALLOWED.value(),"一张发票只能包含一个机构");
            }

            if(!userId.equals(orgOrder.getUserId())){
                throw  new ServiceException(ExceptionType.OP_NOT_ALLOWED.value(),"一张发票只能包含一个用户");
            }
        }
        //已经都申请过开发票了
        if(orderIds.isEmpty() || orders.isEmpty())
        {
            return;
        }
        Optional<UserAddressee> userAddresseeOptional = userAddresseeService.findById(addresseeId);
        Optional<UserInvoice> userInvoiceOptional = userInvoiceService.findById(invoiceId);
        if(!userAddresseeOptional.isPresent()|| !userInvoiceOptional.isPresent()){
            throw  new ServiceException(ExceptionType.PARAM_ERROR.value(),"开票信息或者收件人设置错误");
        }
        OrgOrder oneOrder = orders.get(0);

        OrderInvoiceRecord orderInvoiceRecord = OrderInvoiceRecord.builder()
                .addresseeId(userAddresseeOptional.get().getAddresseeId())
                .receiveUserName(userAddresseeOptional.get().getReceiveUserName())
                .receiveUserPhone(userAddresseeOptional.get().getReceiveUserPhone())
                .invoiceId(userInvoiceOptional.get().getInvoiceId())
                .invoiceTitle(userInvoiceOptional.get().getInvoiceTitle())
                .orderType(OrderType.ORG_ORDER)
                .userId(userAdapter.getUser().getUserId())
                .userName(userAdapter.getUser().getUserRealName())
                .orgId(oneOrder.getOrgId())
                .orgName(oneOrder.getOrgName())
                .build();

        SetEntityProperties.getInstance().setProperties(orderInvoiceRecord);
        orderInvoiceRecord = orderInvoiceRecordService.addOrderInvoiceRecord(orderInvoiceRecord);


        orgOrderDao.updateOrderInvoiceRecordId(orderIds,orderInvoiceRecord.getOirId(),IsInvoiced.APPLY_INVOICE);

    }
}
