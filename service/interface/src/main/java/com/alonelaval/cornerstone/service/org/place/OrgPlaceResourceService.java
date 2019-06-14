package com.alonelaval.cornerstone.service.org.place;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.OrgPlaceResource;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgPlaceResourceService  extends IBaseService<OrgPlaceResource,Integer> {
    default OrgPlaceResource addOrgPlaceResource(OrgPlaceResource orgPlaceResource) throws Exception{
        return this.add(orgPlaceResource);
   }

}