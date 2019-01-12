package com.alonelaval.cornerstone.servce.impl.org.employee;


import com.google.common.collect.Lists;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.VmOrgCoachDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeSkill;
import com.alonelaval.cornerstone.entity.biz.QVmOrgCoach;
import com.alonelaval.cornerstone.entity.biz.VmOrgCoach;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.VmOrgCoachModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeWorkdayService;
import com.alonelaval.cornerstone.service.org.employee.VmOrgCoachService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("vmOrgCoachService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class VmOrgCoachServiceImpl extends AbstractBaseService<VmOrgCoach,Integer> implements VmOrgCoachService {
    @Autowired
    VmOrgCoachDao vmOrgCoachDao;
    @Autowired
    OrgEmployeeWorkdayService orgEmployeeWorkdayService;
    


  	@Override
    public Page<VmOrgCoach> findByModelAndPage(Model model, Page page) throws Exception {
        VmOrgCoachModel vmOrgCoachModel = (VmOrgCoachModel) model;


        WhereBuilder builder = WhereBuilder.build();

        if(vmOrgCoachModel.getState() == null ){
            builder.in(QVmOrgCoach.vmOrgCoach.state,State.ENABLED,State.DISABLED);
        }else
        {
            builder.and(QVmOrgCoach.vmOrgCoach.state.eq(vmOrgCoachModel.getState()));
        }

        builder.startWith(QVmOrgCoach.vmOrgCoach.userName,vmOrgCoachModel.getUserName());
        builder.startWith(QVmOrgCoach.vmOrgCoach.phone,vmOrgCoachModel.getPhone());
        builder.and(QVmOrgCoach.vmOrgCoach.eduBackground,vmOrgCoachModel.getEduBackground());
        builder.in(QVmOrgCoach.vmOrgCoach.secondCategoryId,vmOrgCoachModel.getSecondCategoryIds());
//        builder.and(QVmOrgCoach.vmOrgCoach.isCoach,IsCoach.TRUE);
        page  =vmOrgCoachDao.findAllByPredicateAndPage(builder.predicate(),page);

        List<VmOrgCoach> coachList = page.getData();

        Map<Integer,List<VmOrgCoach>> orgCoachMap= coachList.stream().collect(groupingBy(VmOrgCoach::getEmployeId));


        List<OrgEmployee> orgEmployees = Lists.newArrayList();

        for(Map.Entry<Integer,List<VmOrgCoach>> entry:orgCoachMap.entrySet()){
            OrgEmployee orgEmployee = OrgEmployee.builder().build();
            VmOrgCoach vmOrgCoach = entry.getValue().get(0);
            BeanUtils.copyProperties(vmOrgCoach,orgEmployee);
            List<OrgEmployeeSkill> employeeSkills = Lists.newArrayList();
            for(VmOrgCoach vmOrgCoach1 : entry.getValue()){
                OrgEmployeeSkill orgEmployeeSkill = new OrgEmployeeSkill();
                BeanUtils.copyProperties(vmOrgCoach1,orgEmployeeSkill);
                employeeSkills.add(orgEmployeeSkill);
            }
            orgEmployee.setSkills(employeeSkills);
            orgEmployee.setWorkdays(orgEmployeeWorkdayService.findAllByEmployeId(orgEmployee.getEmployeId()));

            orgEmployees.add(orgEmployee);
        }

        page.setData(orgEmployees);
        return page;
    }
    
    @Override
    protected IBaseDao<VmOrgCoach,Integer> getBaseDao() {
        return vmOrgCoachDao;
    }
}
