package com.alonelaval.cornerstone.dao.inter.platform;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.PlatformShopkeeper;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface PlatformShopkeeperDao  extends IBaseDao<PlatformShopkeeper,Integer> {
    PlatformShopkeeper findByUserId(Integer userId)throws DaoException;
}