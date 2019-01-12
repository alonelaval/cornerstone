package com.alonelaval.cornerstone.dao.inter.org;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.Org;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface OrgDao  extends IBaseDao<Org,Integer> {
    Org findOrgByOrgName(String orgName)throws DaoException;
}
