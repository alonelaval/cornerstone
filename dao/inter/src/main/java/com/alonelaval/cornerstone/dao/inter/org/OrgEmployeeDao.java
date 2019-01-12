package com.alonelaval.cornerstone.dao.inter.org;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.constants.IsCoach;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface OrgEmployeeDao  extends IBaseDao<OrgEmployee,Integer> {
    OrgEmployee findByOrgIdAndUserId(Integer orgId, Integer userId)throws DaoException;

    List<OrgEmployee> findAllByOrgId(Integer orgId)throws  DaoException;

    /**
     * 查找本机构所有的教练
     * @param orgId
     * @return
     * @throws Exception
     */
    List<OrgEmployee> findAllByOrgIdAndIsCoach(Integer orgId, IsCoach isCoach)throws  DaoException;

    /**
     * 查找教练根据员工ID
     * @param employeIds
     * @return
     * @throws Exception
     */
    List<OrgEmployee> findAllByEmployeIdsAndIsCoach(List<Integer> employeIds, IsCoach isCoach) throws DaoException;

}
