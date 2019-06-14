package com.alonelaval.cornerstone.service.org.student;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.OrgReturnVisit;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgReturnVisitService extends IBaseService<OrgReturnVisit,Integer> {
    default OrgReturnVisit addOrgReturnVisit(OrgReturnVisit orgReturnVisit) throws Exception{
        return  this.add(orgReturnVisit);
   }
}