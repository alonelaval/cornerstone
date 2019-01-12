package com.alonelaval.cornerstone.service.user;

import com.alonelaval.cornerstone.entity.biz.*;
import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface UserRoleService  extends IBaseService<UserRole,Integer> {
    UserRole addUserRole(UserRole userRole) throws Exception;

    List<UserRole> findAllByUserIdAndOwnTypeAndOrgId(Integer userId, RoleOwnType ownType, Integer orgId)throws Exception;

    List<UserRole> findAllByUserIdAndOwnType(Integer userId, RoleOwnType ownType)throws Exception;


    List<UserRole> findAllByUserIdAndOwnTypeAndOrgIdAndRoleIdIn(Integer userId,RoleOwnType ownType,Integer orgId,List<Integer> roleIds)throws  Exception;

    List<UserRole> addOrgUserRole(List<Role> roles, Org org, User user)throws  Exception;
    List<UserRole> addUserRoles(List<Role> roles,User user)throws  Exception;
    UserRole addUserRole(Role role,User user,RoleOwnType roleOwnType) throws  Exception;

    /**
     * B端添加权限
     * @param roleIds
     * @param orgEmployee
     * @return
     * @throws Exception
     */
    List<UserRole> addOrgEmployeeRole(List<Integer> roleIds,OrgEmployee orgEmployee)throws  Exception;

    /**
     * P端给店主添加权限，给店主添加权限，即默认为该店主的机构添加权限
     * @param roleIds
     * @param platformShopkeeper
     * @return
     * @throws Exception
     */
    List<UserRole> addPlatformShopkeeperRole(List<Integer> roleIds,PlatformShopkeeper platformShopkeeper)throws  Exception;


}