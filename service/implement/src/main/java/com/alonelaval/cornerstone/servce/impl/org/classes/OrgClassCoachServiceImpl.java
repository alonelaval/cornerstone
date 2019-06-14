package com.alonelaval.cornerstone.servce.impl.org.classes;

import com.google.common.collect.Lists;
import com.alonelaval.common.util.AssertUtil;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgClassCoachDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.biz.OrgClass;
import com.alonelaval.cornerstone.entity.biz.OrgClassCoach;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.biz.QOrgClassCoach;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.CoachType;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.classes.OrgClassCoachService;
import com.alonelaval.cornerstone.service.org.classes.OrgClassService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgClassCoachService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgClassCoachServiceImpl extends AbstractBaseService<OrgClassCoach,Integer>  implements OrgClassCoachService {
    @Autowired
    OrgClassCoachDao orgClassCoachDao;
    @Autowired
    OrgClassService orgClassService;
    @Autowired
    OrgEmployeeService orgEmployeeService;
    

    @Override
    protected IBaseDao<OrgClassCoach,Integer> getBaseDao() {
        return orgClassCoachDao;
    }

    @Override
    public List<OrgClassCoach> addClassCoachs(List<OrgEmployee> orgEmployees, OrgClass orgClass) throws Exception {
        if(orgEmployees != null && !orgEmployees.isEmpty()){
            List<OrgClassCoach> classCoaches = Lists.newArrayList();
            for(OrgEmployee orgEmployee : orgEmployees){
                classCoaches.add(this.add(createClassCoach(orgClass,orgEmployee)));
            }
            return classCoaches;
        }
        return Collections.emptyList();
    }


    private OrgClassCoach createClassCoach(OrgClass orgClass,OrgEmployee orgEmployee){
        OrgClassCoach classCoach = OrgClassCoach.builder()
                .classId(orgClass.getClassId())
                .className(orgClass.getClassName())
                .courseId(orgClass.getCourseId())
                .courseName(orgClass.getCourseName())
                .orgId(orgEmployee.getOrgId())
                .orgName(orgEmployee.getOrgName())
                .userId(orgEmployee.getUserId())
                .userName(orgEmployee.getUserName())
                .employeId(orgEmployee.getEmployeId())
                .coachType(orgEmployee.getEmployeId().equals(orgClass.getMainCoachEmployeId()) ?
                        CoachType.CHIEF_COACH:CoachType.ASSISTANT_COACH)
                .build();

        SetEntityProperties.getInstance().setProperties(classCoach);
        return classCoach;
    }

    @Override
    public List<OrgClassCoach> addOrgCoachs(Integer classId, List<Integer> employeIds) throws Exception {

        if(employeIds != null && !employeIds.isEmpty()){
            Optional<OrgClass> optionalOrgClass = orgClassService.findById(classId);
            if(optionalOrgClass.isPresent()){
                List<OrgEmployee> orgEmployees =orgEmployeeService.findAllByIds(employeIds);
                List<OrgClassCoach> classCoaches = Lists.newArrayList();
                for(OrgEmployee orgEmployee : orgEmployees) {
                    classCoaches.add(this.addOrUpdate(optionalOrgClass.get(),orgEmployee));
                }
                return classCoaches;
            }
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public OrgClassCoach addOrUpdate(OrgClass orgClass, OrgEmployee orgEmployee) throws Exception {
        Optional<OrgClassCoach> optionalOrgClassCoach = this.findCoachByClassIdAndEmployeId(orgClass.getClassId(),
                orgEmployee.getEmployeId());
        if(optionalOrgClassCoach.isPresent()){
            if(!optionalOrgClassCoach.get().getState().equals(State.ENABLED)){
                optionalOrgClassCoach.get().setState(State.ENABLED);
                return orgClassCoachDao.update(optionalOrgClassCoach.get());
            }
           return  optionalOrgClassCoach.get();
        }else{
            return  this.orgClassCoachDao.addEntity(createClassCoach(orgClass,orgEmployee));
        }
    }

    @Override
    public Optional<OrgClassCoach> findCoachByClassIdAndEmployeId(Integer classId, Integer employeId) throws Exception {
        AssertUtil.isTrue(classId == null,ExceptionType.PARAM_ERROR);
        AssertUtil.isTrue(employeId == null ,ExceptionType.PARAM_ERROR);
        WhereBuilder builder = WhereBuilder.build()
            .and(QOrgClassCoach.orgClassCoach.classId,classId)
            .and(QOrgClassCoach.orgClassCoach.employeId,employeId);
        return orgClassCoachDao.findOne(builder.predicate());
    }
}
