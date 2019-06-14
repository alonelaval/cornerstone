package com.alonelaval.cornerstone.service.org;

import com.alonelaval.cornerstone.entity.biz.OrgRelation;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgRelationService  extends IBaseService<OrgRelation,Integer> {
    default OrgRelation addOrgRelation(OrgRelation orgRelation) throws Exception{
        return this.add(orgRelation);
    }

}