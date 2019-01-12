package com.alonelaval.cornerstone.dao.inter.user;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.User;
import com.alonelaval.cornerstone.entity.constants.State;

/**
 * @author huawei
 * @create 2018-07-07
 **/
public interface UserDao extends IBaseDao<User,Integer> {

    User findByLoginName(String loginName)throws DaoException;
    User findByPhone(String phone) throws  DaoException;
    User findByEmail(String email)throws  DaoException;

    void updateUsersState(State state, Integer... userIds)throws DaoException;
}
