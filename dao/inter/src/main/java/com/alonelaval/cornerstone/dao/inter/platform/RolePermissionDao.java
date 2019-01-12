package com.alonelaval.cornerstone.dao.inter.platform;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.RolePermission;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface RolePermissionDao  extends IBaseDao<RolePermission,Integer> {
    List<RolePermission> findAllByRoleIdIn(List<Integer> ids)throws DaoException;

    List<RolePermission> addRolePermission(List<RolePermission> rolePermissions)throws DaoException;
}
