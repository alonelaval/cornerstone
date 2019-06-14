package com.alonelaval.cornerstone.dao.inter.org;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.OrgPlace;

import java.util.Optional;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface OrgPlaceDao  extends IBaseDao<OrgPlace,Integer> {
    Optional<OrgPlace> findOneByPlaceNameAndOrgId(String placeName, Integer orgId) throws DaoException;
}
