package com.alonelaval.cornerstone.service.org;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.Org;
import com.alonelaval.cornerstone.entity.biz.OrgResource;
import com.alonelaval.cornerstone.entity.constants.OrgResourceType;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgResourceService  extends IBaseService<OrgResource,Integer> {
    default OrgResource addOrgResource(OrgResource orgResource) throws Exception{
        return  this.add(orgResource);
    }
    List<OrgResource> addOrgResource(List<String> resourceFiles,Org org,OrgResourceType type) throws Exception;

    List<OrgResource> updateOrgResource(List<String> resourceFiles,Org org,OrgResourceType type) throws Exception;
}