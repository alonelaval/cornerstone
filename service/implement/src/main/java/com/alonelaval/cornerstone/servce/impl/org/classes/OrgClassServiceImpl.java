package com.alonelaval.cornerstone.servce.impl.org.classes;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.exception.ExceptionUtil;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgClassDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.*;
import com.alonelaval.cornerstone.entity.constants.ClassState;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.OrgClassModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.classes.OrgClassCoachService;
import com.alonelaval.cornerstone.service.org.classes.OrgClassService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeService;
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
@Service("orgClassService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgClassServiceImpl extends AbstractBaseService<OrgClass,Integer>  implements OrgClassService {
    @Autowired
    OrgClassDao orgClassDao;
    @Autowired
    OrgEmployeeService orgEmployeeService;
    @Autowired
    OrgClassCoachService orgClassCoachService;

    @Override
    protected IBaseDao<OrgClass,Integer> getBaseDao() {
        return orgClassDao;
    }

    @Override
    public OrgClass changeMainCoach(OrgClassModel classModel) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();

        if(userAdapter.getLoginType().equals(RoleOwnType.ORG_ROLE)){
            Optional<OrgClass> optionalOrgClass = this.findById(classModel.getClassId());
            Optional<OrgEmployee> optionalOrgEmployee =orgEmployeeService.findById(classModel.getMainCoachEmployeId());
            if(optionalOrgClass.isPresent() && optionalOrgEmployee.isPresent()){
                OrgClass orgClass = optionalOrgClass.get();

                if(!orgClass.getMainCoachEmployeId().equals(classModel.getMainCoachEmployeId())) {

                    orgClassCoachService.addOrUpdate(orgClass,optionalOrgEmployee.get());

                    orgClass.setMainCoachEmployeId(optionalOrgEmployee.get().getEmployeId());
                    orgClass.setMainCoachUserId(optionalOrgEmployee.get().getUserId());
                    orgClass.setMainCoachUserName(optionalOrgEmployee.get().getUserName());

                    return this.update(orgClass);
                }
                return orgClass;
            }
        }

        ExceptionUtil.throwServiceException(ExceptionType.NOT_AUTH);
        return null;
    }


    @Override
    public Page<OrgClass> findByModelAndPage(Model model, Page<OrgClass> page) throws Exception {

        OrgClassModel orgClassModel = (OrgClassModel) model;
        WhereBuilder builder = WhereBuilder.build();


        if(orgClassModel.getClassState() == null ){
            builder.and(QOrgClass.orgClass.state.notIn(ClassState.DELETE));
        }else
        {
            builder.and(QOrgClass.orgClass.state.eq(orgClassModel.getClassState()));
        }

        builder.and(QOrgClass.orgClass.secondCategoryId,orgClassModel.getSecondCategoryId());

        builder.startWith(QOrgClass.orgClass.courseName,orgClassModel.getCourseName());
        builder.andBetweenDate(QOrgClass.orgClass.beginDate,orgClassModel.getBeginDate()
            ,orgClassModel.getEndDate());


        return getBaseDao().findAllByPredicateAndPage(builder.predicate(),page);
    }
}
