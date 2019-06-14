package com.alonelaval.cornerstone.servce.impl.org.employee;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.exception.ExceptionUtil;
import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.common.message.SmsCodeGenerator;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.*;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.*;
import com.alonelaval.cornerstone.entity.model.CoachModel;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.OrgEmployeeModel;
import com.alonelaval.cornerstone.entity.model.UserModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.OrgResourceService;
import com.alonelaval.cornerstone.service.org.OrgService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeRecordService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeSkillService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeWorkdayService;
import com.alonelaval.cornerstone.service.platform.PlatformCourseCategoryService;
import com.alonelaval.cornerstone.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgEmployeeService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgEmployeeServiceImpl extends AbstractBaseService<OrgEmployee,Integer>  implements OrgEmployeeService {
    @Autowired
    OrgEmployeeDao orgEmployeeDao;
    @Autowired
    UserService userService;
    @Autowired
    OrgService orgService;
    @Autowired
    PlatformCourseCategoryService platformCourseCategoryService;
    @Autowired
    OrgEmployeeSkillService orgEmployeeSkillService;
    @Autowired
    OrgEmployeeRecordService orgEmployeeRecordService;
    @Autowired
    OrgEmployeeWorkdayService orgEmployeeWorkdayService;
    @Autowired
    OrgResourceService orgResourceService;

    @Override
    public Page<OrgEmployee> findByModelAndPage(Model model, Page<OrgEmployee> page) throws Exception {
        OrgEmployeeModel orgEmployeeModel = (OrgEmployeeModel) model;
        WhereBuilder builder = WhereBuilder.build();


        if(orgEmployeeModel.getState() == null ){
            builder.in(QOrgEmployee.orgEmployee.state,State.ENABLED,State.DISABLED);
        }else
        {
            builder.and(QOrgEmployee.orgEmployee.state.eq(orgEmployeeModel.getState()));
        }

        builder.and(QOrgEmployee.orgEmployee.orgId,orgEmployeeModel.getOrgId());
        builder.and(QOrgEmployee.orgEmployee.gender,orgEmployeeModel.getGender());
        builder.startWith(QOrgEmployee.orgEmployee.userName,orgEmployeeModel.getUserName());
        builder.startWith(QOrgEmployee.orgEmployee.phone,orgEmployeeModel.getPhone());
        builder.and(QOrgEmployee.orgEmployee.position,orgEmployeeModel.getPosition());
        builder.and(QOrgEmployee.orgEmployee.departmentId,orgEmployeeModel.getDepartmentId());
        builder.and(QOrgEmployee.orgEmployee.departmentName,orgEmployeeModel.getDepartmentName());


        return  getBaseDao().findAllByPredicateAndPage(builder.predicate(),page);
    }



    @Override
    protected IBaseDao<OrgEmployee,Integer> getBaseDao() {
        return orgEmployeeDao;
    }

    @Override
    public Optional<OrgEmployee> findByOrgIdAndUserId(Integer orgId, Integer userId) throws Exception {
        return Optional.ofNullable(orgEmployeeDao.findByOrgIdAndUserId(orgId,userId));
    }


    @Override
    public OrgEmployee createOrgEmployee(Org org, User user, EmployeeState employeeState, OrgAccountType orgAccountType,
                                         IsCoach isCoach) throws Exception {
        OrgEmployee orgEmployee = OrgEmployee.builder().orgId(org.getOrgId())
                .orgName(org.getOrgName())
                .userId(user.getUserId())
                .userName(user.getUserRealName())
                .idcard(user.getIdcard())
                .birthday(user.getBirthday())
                .phone(user.getPhone())
                .isCoach(isCoach)
                .gender(user.getGender())
                .orgAccountType(orgAccountType)
                .employeState(employeeState)
                .build();

        SetEntityProperties.getInstance().setProperties(orgEmployee);
        return add(orgEmployee);
    }

    @Override
    public OrgEmployee add(Model model) throws Exception {
        OrgEmployeeModel orgEmployeeModel = (OrgEmployeeModel) model;
        OrgEmployee orgEmployee = OrgEmployee.builder()
                .orgId(orgEmployeeModel.getOrgId())
                .orgName(orgEmployeeModel.getOrgName())
                .userId(orgEmployeeModel.getUserId())
                .userName(orgEmployeeModel.getUserName())
                .idcard(orgEmployeeModel.getIdcard())
                .birthday(orgEmployeeModel.getBirthday())
                .phone(orgEmployeeModel.getPhone())
                .isCoach(orgEmployeeModel.getIsCoach())
                .orgAccountType(orgEmployeeModel.getOrgAccountType())
                .employeState(orgEmployeeModel.getEmployeState())
                .workStartDate(orgEmployeeModel.getWorkStartDate())
                .jobType(orgEmployeeModel.getJobType())
                .gender(orgEmployeeModel.getGender())
                .remark(orgEmployeeModel.getRemark())
                .eduBackground(orgEmployeeModel.getEduBackground())
                .icon(orgEmployeeModel.getIconPath())
                .build();

        SetEntityProperties.getInstance().setProperties(orgEmployee);
        return add(orgEmployee);
    }


    @Override
    public OrgEmployee addCoach(CoachModel coachModel) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();

        if(!userAdapter.getOrg().isPresent() || !userAdapter.getOrg().get().getOrgId().equals(coachModel.getOrgId())){
            throw  new ServiceException(ExceptionType.NOT_AUTH.value(),ExceptionType.NOT_AUTH.desc());
        }
        Optional<Org> optionalOrg = orgService.findById(coachModel.getOrgId());

        if(!optionalOrg.isPresent()){
            throw  new ServiceException(ExceptionType.ORG_NOT_FOUND.value(),ExceptionType.ORG_NOT_FOUND.desc());
        }
        Org org = optionalOrg.get();
        // TODO: 2018/8/12 需要将初始密码发送给用户
        User user = userService.userRegister(UserModel.builder()
                .userName(coachModel.getUserName())
                .birthDay(coachModel.getBirthday())
                .phoneCode(coachModel.getPhoneCode())
                .phone(coachModel.getPhone())
                .loginPassword(SmsCodeGenerator.generateCode())
                .gender(coachModel.getGender())
                .build());

        OrgEmployee orgEmployee = add(OrgEmployeeModel.builder()
                .orgId(org.getOrgId())
                .orgName(org.getOrgName())
                .userId(user.getUserId())
                .userName(coachModel.getUserName())
                .idcard(user.getIdcard())
                .birthday(coachModel.getBirthday())
                .phone(coachModel.getPhone())
                .isCoach(IsCoach.TRUE)
                .orgAccountType(OrgAccountType.SUB_ACCOUNT)
                .employeState(EmployeeState.AUDIT)
                .workStartDate(coachModel.getWorkStartDate())
                .eduBackground(coachModel.getEduBackground())
                .jobType(coachModel.getJobType())
                .gender(coachModel.getGender())
                .iconPath(coachModel.getIconPath())
                .remark(coachModel.getRemark())
                .build());

        //添加专业特长
        orgEmployeeSkillService.addSkill(coachModel.getSecondCategoryIds(),orgEmployee);
        //添加教练履历
        orgEmployeeRecordService.addRecords(coachModel.getOrgEmployeeRecordModels(),orgEmployee);
        //添加教练工作时间
        orgEmployeeWorkdayService.addWorkdays(coachModel.getOrgEmployeeWorktimes(),orgEmployee);

        return orgEmployee;
    }



    @Override
    public List<OrgEmployee> findAllByOrgId(Integer orgId) throws Exception {

        return orgEmployeeDao.findAllByOrgId(orgId);
    }

    @Override
    public List<OrgEmployee> findAllCoachByOrgId(Integer orgId) throws Exception {
        return orgEmployeeDao.findAllByOrgIdAndIsCoach(orgId,IsCoach.TRUE);
    }

    @Override
    public List<OrgEmployee> findAllCoachByEmployeIds(List<Integer> employeIds) throws Exception {
        return orgEmployeeDao.findAllByEmployeIdsAndIsCoach(employeIds,IsCoach.TRUE);
    }

    @Override
    public OrgEmployee updateInfo(OrgEmployeeModel employeeModel, List<String> resourceFileNames, String icon)throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();

        if(userAdapter.getOrgEmployee() !=null){

            userAdapter.getOrgEmployee().setUserName(employeeModel.getUserName());
            userAdapter.getOrgEmployee().setPhone(employeeModel.getPhone());
            userAdapter.getOrgEmployee().setGender(employeeModel.getGender());
            userAdapter.getOrgEmployee().setIcon(icon);
            userAdapter.getOrgEmployee().setRemark(employeeModel.getRemark());
            this.update(userAdapter.getOrgEmployee());

            if(userAdapter.getOrgEmployee().getOrgAccountType().equals(OrgAccountType.MAIN_ACCOUNT)){
                if(resourceFileNames != null && !resourceFileNames.isEmpty()) {
                    orgResourceService.updateOrgResource(resourceFileNames,userAdapter.getOrg().get(),OrgResourceType.BUSINESS_LICENSE);
                }
            }
            return  userAdapter.getOrgEmployee();
        }
        ExceptionUtil.throwServiceException(ExceptionType.OP_NOT_ALLOWED);
        return null;
    }


}
