package com.alonelaval.cornerstone.dao.inter.user;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.UserAddresseeTag;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface UserAddresseeTagDao  extends IBaseDao<UserAddresseeTag,Integer> {
     void deleteAllByAddresseeId(Integer addresseeId) throws DaoException;
}
