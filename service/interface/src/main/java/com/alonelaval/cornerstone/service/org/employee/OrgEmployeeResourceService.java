package com.alonelaval.cornerstone.service.org.employee;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeResource;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgEmployeeResourceService  extends IBaseService<OrgEmployeeResource,Integer> {
    default OrgEmployeeResource addOrgEmployeeResource(OrgEmployeeResource orgEmployeeResource) throws Exception{
        return  add(orgEmployeeResource);
   }

}