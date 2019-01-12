package com.alonelaval.cornerstone.service.platform;

import com.alonelaval.cornerstone.entity.biz.OrgPermission;
import com.alonelaval.cornerstone.entity.biz.Role;
import com.alonelaval.cornerstone.entity.biz.RolePermission;
import com.alonelaval.cornerstone.entity.biz.SysPermission;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface RolePermissionService  extends IBaseService<RolePermission,Integer> {
    RolePermission addRolePermission(RolePermission rolePermission) throws Exception;
    List<RolePermission> findAllByRoleIdIn(List<Integer> ids )throws Exception;
    List<RolePermission> addRolePermissions(List<RolePermission> rolePermissions)throws Exception;
    List<RolePermission> addRolePermissions(List<SysPermission> sysPermissions,Role role)throws Exception;

    List<RolePermission> addOrgRolePermissions(List<OrgPermission> orgPermissions, Role role)throws Exception;

    /***
     * 界面添加权限，有可能是删除
     * @param permissions
     * @param roleId
     * @return
     * @throws Exception
     */
    List<RolePermission> addRoleSysPermissions(List<Integer> permissions, Integer roleId)throws Exception;

    /***
     *界面添加机构角色的权限，有可能是删除
     * @param permissions
     * @param roleId
     * @return
     * @throws Exception
     */
    List<RolePermission> addRoleOrgPermissions(List<Integer> opIds, Integer roleId)throws Exception;
}