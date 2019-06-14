package com.alonelaval.cornerstone.servce.impl.org.employee;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.exception.DaoException;
import com.alonelaval.common.exception.ExceptionUtil;
import com.alonelaval.common.util.AssertUtil;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeCheckinDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.*;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.OrgEmployeeCheckinModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.classes.OrgClassCoachService;
import com.alonelaval.cornerstone.service.org.classes.OrgClassService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeCheckinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgEmployeeCheckinService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgEmployeeCheckinServiceImpl extends AbstractBaseService<OrgEmployeeCheckin,Integer>  implements OrgEmployeeCheckinService {
    @Autowired
    OrgEmployeeCheckinDao orgEmployeeCheckinDao;
    @Autowired
    OrgClassCoachService orgClassCoachService;
    @Autowired
    OrgClassService orgClassService;


    @Override
    public OrgEmployeeCheckin add(Model model) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();

        OrgEmployeeCheckinModel orgEmployeeCheckinModel = (OrgEmployeeCheckinModel) model;

        Optional<OrgClassCoach> optionalOrgClassCoach = orgClassCoachService.findCoachByClassIdAndEmployeId(
                orgEmployeeCheckinModel.getClassId(),orgEmployeeCheckinModel.getEmployeId());

        if(optionalOrgClassCoach.isPresent() && optionalOrgClassCoach.get().getOrgId().equals(userAdapter.getOrg().get()
                .getOrgId())){
            //代签到
            AssertUtil.isTrue(!optionalOrgClassCoach.get().getEmployeId().equals(userAdapter.getOrgEmployee().getEmployeId()),
                    ExceptionType.OP_NOT_ALLOWED);

            Optional<OrgEmployeeCheckin> optionalOrgEmployeeCheckin = findEmployeeCheckin(userAdapter.getOrgEmployee(),
                    optionalOrgClassCoach.get().getCourseId(),
                    optionalOrgClassCoach.get().getClassId()
                    );
            //已签到
            if(optionalOrgEmployeeCheckin.isPresent()){
                optionalOrgEmployeeCheckin.get().setEndTime(LocalDateTime.now());
                return  this.update(optionalOrgEmployeeCheckin.get());
            }
            //未签到
            else {
                Optional<OrgClass> orgClass =orgClassService.findById(orgEmployeeCheckinModel.getClassId());
                OrgEmployeeCheckin orgEmployeeCheckin = OrgEmployeeCheckin.builder()
                        .beginTime(LocalDateTime.now())
                        .endTime(LocalDateTime.now())
                        .courseId(optionalOrgClassCoach.get().getCourseId())
                        .courseName(optionalOrgClassCoach.get().getCourseName())
                        .classId(optionalOrgClassCoach.get().getClassId())
                        .className(optionalOrgClassCoach.get().getClassName())
                        .orgId(optionalOrgClassCoach.get().getOrgId())
                        .orgName(optionalOrgClassCoach.get().getOrgName())
                        .secondCategoryId(orgClass.get().getSecondCategoryId())
                        .secondCategoryName(orgClass.get().getSecondCategoryName())
                        .userId(userAdapter.getOrgEmployee().getUserId())
                        .userName(userAdapter.getOrgEmployee().getUserName())
                        .employeId(userAdapter.getOrgEmployee().getEmployeId())
                        .checkinType(orgEmployeeCheckinModel.getCheckinType())
                        .build();

                SetEntityProperties.getInstance().setProperties(orgEmployeeCheckin);

                return  this.add(orgEmployeeCheckin);
            }

        }
        ExceptionUtil.throwServiceException(ExceptionType.OP_NOT_ALLOWED);
        return  null;
    }

    private Optional<OrgEmployeeCheckin> findEmployeeCheckin(OrgEmployee orgEmployee,Integer courseId,Integer classId) throws Exception, DaoException {
        AssertUtil.isTrue(orgEmployee.getOrgId() == null,ExceptionType.PARAM_ERROR);
        AssertUtil.isTrue(orgEmployee.getEmployeId() == null,ExceptionType.PARAM_ERROR);

        return  orgEmployeeCheckinDao.findOne(WhereBuilder.build()
                .and(QOrgEmployeeCheckin.orgEmployeeCheckin.orgId,orgEmployee.getOrgId())
                .and(QOrgEmployeeCheckin.orgEmployeeCheckin.employeId,orgEmployee.getEmployeId())
                .and(QOrgEmployeeCheckin.orgEmployeeCheckin.courseId,courseId)
                .and(QOrgEmployeeCheckin.orgEmployeeCheckin.classId,classId)
                .andLocalDateTimeEquals(QOrgEmployeeCheckin.orgEmployeeCheckin.createTime,LocalDateTime.now())
                .predicate());

    }



    @Override
    protected IBaseDao<OrgEmployeeCheckin,Integer> getBaseDao() {
        return orgEmployeeCheckinDao;
    }
}
