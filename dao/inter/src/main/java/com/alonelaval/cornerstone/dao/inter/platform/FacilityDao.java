package com.alonelaval.cornerstone.dao.inter.platform;


import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.Facility;

import java.util.Optional;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface FacilityDao  extends IBaseDao<Facility,Integer> {
    Optional<Facility> findOneByFacilityName(String facilityName)throws DaoException;
}