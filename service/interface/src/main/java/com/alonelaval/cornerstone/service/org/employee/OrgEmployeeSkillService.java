package com.alonelaval.cornerstone.service.org.employee;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeSkill;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgEmployeeSkillService  extends IBaseService<OrgEmployeeSkill,Integer> {
    default OrgEmployeeSkill addOrgEmployeeSkill(OrgEmployeeSkill orgEmployeeSkill) throws Exception{
        return  this.add(orgEmployeeSkill);
   }

   List<OrgEmployeeSkill> addSkill(List<Integer> categoryIds, OrgEmployee orgEmployee)throws Exception;



}