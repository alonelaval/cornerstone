package com.alonelaval.cornerstone.service.org;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.Org;
import com.alonelaval.cornerstone.entity.biz.OrgPermission;
import com.alonelaval.cornerstone.entity.biz.SysPermission;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgPermissionService  extends IBaseService<OrgPermission,Integer> {
    default  OrgPermission addOrgPermission(OrgPermission orgPermission) throws Exception{
        return  this.add(orgPermission);
    }
    List<OrgPermission> findAllByOpIdIn(List<Integer> ids) throws Exception;

    List<OrgPermission> addOrgPermissionsBySysPermissions(List<SysPermission> sysPermissions, Org org)throws  Exception;
    List<OrgPermission>  addOrgPermissions(List<OrgPermission> orgPermissions) throws  Exception;

    void deleteAllByOrgId(List<Integer> ids,Integer orgId)throws  Exception;
    void enableAllByOrgId(List<Integer> ids,Integer orgId)throws  Exception;
}
