package com.alonelaval.cornerstone.dao.inter.platform;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.Role;
import com.alonelaval.cornerstone.entity.constants.RoleCreateType;

import java.util.List;
import java.util.Optional;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface RoleDao  extends IBaseDao<Role,Integer> {

    Optional<List<Role>> findByIds(List<Integer> ids)throws DaoException;

    Optional<List<Role>> findByOrgId(Integer orgId)throws  DaoException;

    Optional<List<Role>> findByOrgIdAndFromRoleId(Integer orgId, List<Integer> fromRoleIds)throws  DaoException;
    Optional<List<Role>> findByOrgIdAndFromRoleIdNotNull(Integer orgId)throws  DaoException;


    /**
     * 找出平台给系统分配的角色
     * @param orgId
     * @return
     * @throws Exception
     */
    Optional<List<Role>> findByOrgIdAndCreateType(Integer orgId, RoleCreateType roleCreateType)throws  DaoException;

}
