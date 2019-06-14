package com.alonelaval.cornerstone.dao.inter.user;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.UserRole;
import com.alonelaval.cornerstone.entity.constants.RoleOwnType;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface UserRoleDao  extends IBaseDao<UserRole,Integer> {
    /***
     * 获取用户所有角色
     * @param userId
     * @return
     * @throws DaoException
     */
    List<UserRole> findRoleByUserId(Integer userId)throws DaoException;
    /***
     * 获取用户角色，不是在机构的角色
     * @param userId
     * @return
     * @throws DaoException
     */
    List<UserRole> findRoleByUserIdAndOrgIdIsNull(Integer userId)throws DaoException;
    List<UserRole>  findRoleByUserIdAndOrgId(Integer userId, Integer orgId)throws DaoException;


    List<UserRole> findAllByUserIdAndOwnTypeAndOrgId(Integer userId, RoleOwnType ownType, Integer orgId)throws DaoException;

    List<UserRole> findAllByUserIdAndOwnTypeAndOrgIdAndFormRoleIdIn(Integer userId, RoleOwnType ownType, Integer orgId, List<Integer> fromRoleIds)throws DaoException;

    List<UserRole> findAllByUserIdAndOwnType(Integer userId, RoleOwnType ownType)throws DaoException;

    List<UserRole> findAllByUserIdAndOwnTypeAndOrgIdAndRoleIdIn(Integer userId, RoleOwnType ownType, Integer orgId, List<Integer> roleIds)throws DaoException;


 }
