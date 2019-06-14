package com.alonelaval.cornerstone.dao.inter.platform;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.SysPermission;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface SysPermissionDao  extends IBaseDao<SysPermission,Integer> {
    List<SysPermission> findAllByPermissionIdIn(List<Integer> ids)throws DaoException;
}
