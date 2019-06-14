package com.alonelaval.cornerstone.servce.impl.org.student;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgStudentDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.*;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.OrgStudentModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.student.OrgStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgStudentService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgStudentServiceImpl extends AbstractBaseService<OrgStudent,Integer>  implements OrgStudentService {
    @Autowired
    OrgStudentDao orgStudentDao;


    @Override
    public Page<OrgStudent> findByModelAndPage(Model model, Page<OrgStudent> page) throws Exception {
        OrgStudentModel orgStudentModel = (OrgStudentModel) model;
        WhereBuilder builder = WhereBuilder.build();


        if(orgStudentModel.getState() == null ){
            builder.in(QOrgStudent.orgStudent.state,State.ENABLED,State.DISABLED);
        }else
        {
            builder.and(QOrgStudent.orgStudent.state.eq(orgStudentModel.getState()));
        }

        builder.and(QOrgStudent.orgStudent.orgId,orgStudentModel.getOrgId());
        builder.startWith(QOrgStudent.orgStudent.studentUserName,orgStudentModel.getStudentUserName());
        builder.startWith(QOrgStudent.orgStudent.phone,orgStudentModel.getPhone());
        builder.startWith(QOrgStudent.orgStudent.guardianUserName,orgStudentModel.getGuardianUserName());

        return orgStudentDao.findAllByPredicateAndPage(builder.predicate(),page);
    }

    @Override
    protected IBaseDao<OrgStudent,Integer> getBaseDao() {
        return orgStudentDao;
    }

    @Override
    public OrgStudent addStudent(OrgStudentModel orgStudentModel) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        if(userAdapter.getLoginType().equals(RoleOwnType.USER_ROLE)){
            

        }
        throw new ServiceException(ExceptionType.ORG_NOT_FOUND.value(),ExceptionType.ORG_NOT_FOUND.desc());
    }

    @Override
    public Optional<OrgStudent> findByUserStudentId(Integer userStudentId) throws Exception {
        return orgStudentDao.findByUserStudentId(userStudentId);
    }

    @Override
    public Optional<OrgStudent> findByStudentUserId(Integer studentUserId) throws Exception {
        return orgStudentDao.findByStudentUserId(studentUserId);
    }

    @Override
    public OrgStudent addStudent(UserStudent userStudent, User user,Org org) throws Exception {
        Optional<UserStudent> userStudentOptional = Optional.ofNullable(userStudent);
        //上课人为下单用户
        OrgStudent orgStudent= null;
        if(!userStudentOptional.isPresent()) {
            orgStudent = OrgStudent.builder()
                    .studentUserId(user.getUserId())
                    .studentUserName(user.getUserRealName())
                    .totalJoinNum(1)
                    .currentCourseNum(1)
                    .phone(user.getPhone())
                    .orgId(org.getOrgId())
                    .orgName(org.getOrgName())
                    .gender(user.getGender())
                    .build();
        }
        //指定了上课人
        else{
            orgStudent = OrgStudent.builder()
                    .userStudentId(userStudentOptional.get().getUserStudentId())
                    .studentUserId(userStudentOptional.get().getStudentUserId())
                    .studentUserName(userStudentOptional.get().getStudentUserName())
                    .guardianUserId(userStudentOptional.get().getGuardianUserId())
                    .guardianUserName(userStudentOptional.get().getGuardianUserName())
                    .totalJoinNum(1)
                    .currentCourseNum(1)
                    .phone(userStudentOptional.get().getPhone())
                    .orgId(org.getOrgId())
                    .orgName(org.getOrgName())
                    .gender(userStudentOptional.get().getGender())
                    .build();

        }
        SetEntityProperties.getInstance().setProperties(orgStudent);
        orgStudent = this.add(orgStudent);
        return  orgStudent;
    }
}
