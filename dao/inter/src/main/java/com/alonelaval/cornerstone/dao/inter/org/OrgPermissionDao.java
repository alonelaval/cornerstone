package com.alonelaval.cornerstone.dao.inter.org;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.OrgPermission;
import com.alonelaval.cornerstone.entity.constants.State;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface OrgPermissionDao  extends IBaseDao<OrgPermission,Integer> {

    List<OrgPermission> findAllByOpIdIn(List<Integer> ids) throws DaoException;

    List<OrgPermission> addOrgPermissions(List<OrgPermission> orgPermissions) throws  DaoException;

    void updateAllByOrgId(List<Integer> ids, Integer orgId, State state)throws  DaoException;
}
