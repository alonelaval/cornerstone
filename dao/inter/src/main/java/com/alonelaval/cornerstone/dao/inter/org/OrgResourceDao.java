package com.alonelaval.cornerstone.dao.inter.org;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.OrgResource;
import com.alonelaval.cornerstone.entity.constants.State;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface OrgResourceDao  extends IBaseDao<OrgResource,Integer> {

    void updateStateByOrgId(Integer orgId, State state)throws DaoException;
}
