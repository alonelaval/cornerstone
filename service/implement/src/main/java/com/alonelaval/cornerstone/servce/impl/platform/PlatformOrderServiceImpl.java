package com.alonelaval.cornerstone.servce.impl.platform;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.common.snowflake.SnowflakeUidGenerator;
import com.alonelaval.common.util.AmountPriceUtil;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.platform.PlatformOrderDao;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.OrderInvoiceRecord;
import com.alonelaval.cornerstone.entity.biz.PlatformOrder;
import com.alonelaval.cornerstone.entity.biz.UserAddressee;
import com.alonelaval.cornerstone.entity.biz.UserInvoice;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.*;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.PlatformOrderModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.platform.PlatformOrderService;
import com.alonelaval.cornerstone.service.user.OrderInvoiceRecordService;
import com.alonelaval.cornerstone.service.user.UserAddresseeService;
import com.alonelaval.cornerstone.service.user.UserInvoiceService;
import com.alonelaval.cornerstone.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("platformOrderService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class PlatformOrderServiceImpl extends AbstractBaseService<PlatformOrder,Integer> implements PlatformOrderService {
    @Autowired
    PlatformOrderDao platformOrderDao;
    @Autowired
    UserService userService;
    @Autowired
    SnowflakeUidGenerator platformOrderUidGenerator;
    @Autowired
    OrderInvoiceRecordService orderInvoiceRecordService;
    @Autowired
    UserAddresseeService userAddresseeService;
    @Autowired
    UserInvoiceService userInvoiceService;

    @Override
    public PlatformOrder add(PlatformOrder platformOrder) throws Exception {
        if(platformOrder.getUserId() == null){
            throw  new ServiceException(ExceptionType.USER_NOT_FOUND.value(),ExceptionType.USER_NOT_FOUND.desc());
        }
        platformOrder.setDealNumber(platformOrderUidGenerator.getUID()+"");

        SetEntityProperties.getInstance().setProperties(platformOrder);
        return super.add(platformOrder);
    }

    @Override
    public PlatformOrder add(Model model) throws Exception {
        PlatformOrderModel platformOrderModel = (PlatformOrderModel) model;
        UserAdapter userAdapter  = (UserAdapter) UserContextHolder.getInstance().getUser();

        PlatformOrder platformOrder = PlatformOrder.builder()
                .buyContent(platformOrderModel.getBuyContent())
                .dealAmount(AmountPriceUtil.input(platformOrderModel.getDealAmount()))
                .dealDate(platformOrderModel.getDealDate() ==null ? LocalDate.now(): platformOrderModel.getDealDate())
                .dealType(platformOrderModel.getDealType())
                .isInvoiced(IsInvoiced.NOT_INVOICE)
                .orgId(platformOrderModel.getOrgId())
                .orgName(platformOrderModel.getOrgName())
                .phone(platformOrderModel.getPhone())
                .productVersion(platformOrderModel.getProductVersion())
                .orderState(OrderState.NOT_PAID)
                .userId(platformOrderModel.getUserId())
                .userName(platformOrderModel.getUserName())
                .orgId(platformOrderModel.getOrgId())
                .orgName(platformOrderModel.getOrgName())
                .build();

        if(userAdapter.getLoginType().equals(RoleOwnType.PLATFORM_ROLE)){
                platformOrder.setAddUserName(userAdapter.getUser().getUserRealName());
                platformOrder.setAddUserId(userAdapter.getUser().getUserId());
        }

        return this.add(platformOrder);
    }

    @Override
    protected IBaseDao<PlatformOrder,Integer> getBaseDao() {
        return platformOrderDao;
    }

    @Override
    public void invoicePlatformOrder(List<Integer> orderIds, Integer invoiceId, Integer addresseeId) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        List<PlatformOrder> platformOrders = platformOrderDao.findAllByIds(orderIds);

        if(platformOrders ==null || platformOrders.isEmpty()){
            return ;
        }
        Integer userId = null;
        for(PlatformOrder platformOrder :platformOrders){

            if(!platformOrder.getOrderState().equals(IsInvoiced.NOT_INVOICE)){
                orderIds.remove(platformOrder.getOrderId());
            }
            if(userId == null){
                userId = platformOrder.getUserId();
                continue;
            }
            if(!userId.equals(platformOrder.getUserId())){
                throw  new ServiceException(ExceptionType.OP_NOT_ALLOWED.value(),"一张发票只能包含一个用户");
            }
        }
        //已经都申请过开发票了
        if(orderIds.isEmpty() || platformOrders.isEmpty())
        {
            return;
        }
        Optional<UserAddressee> userAddresseeOptional = userAddresseeService.findById(addresseeId);
        Optional<UserInvoice> userInvoiceOptional = userInvoiceService.findById(invoiceId);
        if(!userAddresseeOptional.isPresent()|| !userInvoiceOptional.isPresent()){
            throw  new ServiceException(ExceptionType.PARAM_ERROR.value(),"开票信息或者收件人设置错误");
        }
        PlatformOrder oneOrder = platformOrders.get(0);

        OrderInvoiceRecord orderInvoiceRecord = OrderInvoiceRecord.builder()
                .addresseeId(userAddresseeOptional.get().getAddresseeId())
                .receiveUserName(userAddresseeOptional.get().getReceiveUserName())
                .receiveUserPhone(userAddresseeOptional.get().getReceiveUserPhone())
                .invoiceId(userInvoiceOptional.get().getInvoiceId())
                .invoiceTitle(userInvoiceOptional.get().getInvoiceTitle())
                .orderType(OrderType.PLATFORM_ORDER)
                .userId(userAdapter.getUser().getUserId())
                .userName(userAdapter.getUser().getUserRealName())
                .orgId(oneOrder.getOrgId())
                .orgName(oneOrder.getOrgName())
                .build();

        SetEntityProperties.getInstance().setProperties(orderInvoiceRecord);
        orderInvoiceRecord = orderInvoiceRecordService.addOrderInvoiceRecord(orderInvoiceRecord);


        platformOrderDao.updatePlatformOrderInvoiceRecordId(orderIds,orderInvoiceRecord.getOirId(),IsInvoiced.APPLY_INVOICE);

    }
}
