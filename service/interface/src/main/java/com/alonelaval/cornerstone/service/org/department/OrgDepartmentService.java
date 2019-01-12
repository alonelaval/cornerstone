package com.alonelaval.cornerstone.service.org.department;

import com.alonelaval.cornerstone.entity.biz.OrgDepartment;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgDepartmentService  extends IBaseService<OrgDepartment,Integer> {
    default OrgDepartment addOrgDepartment(OrgDepartment orgDepartment) throws Exception{
        return this.add(orgDepartment);
    }



}