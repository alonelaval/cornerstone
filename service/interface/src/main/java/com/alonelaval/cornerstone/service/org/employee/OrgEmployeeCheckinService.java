package com.alonelaval.cornerstone.service.org.employee;

import com.alonelaval.cornerstone.entity.biz.OrgEmployeeCheckin;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgEmployeeCheckinService  extends IBaseService<OrgEmployeeCheckin,Integer> {
    default OrgEmployeeCheckin addOrgEmployeeCheckin(OrgEmployeeCheckin orgEmployeeCheckin) throws Exception{
        return  this.add(orgEmployeeCheckin);
   }

}