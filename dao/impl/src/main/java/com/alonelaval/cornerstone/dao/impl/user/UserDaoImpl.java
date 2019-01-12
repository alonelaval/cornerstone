package com.alonelaval.cornerstone.dao.impl.user;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.user.UserDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.UserRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.UserDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.UserRepository;
import com.alonelaval.cornerstone.entity.biz.User;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="userDao")
public class UserDaoImpl  extends AbstractBaseDao<User,Integer> implements UserDao {

    @Autowired
    UserRepository userRepository;

    @Override
    protected BaseRepository<User, Integer> getBaseRepository() {
        return userRepository;
    }

    @Override
    public User findByLoginName(String loginName) throws DaoException {
        try {
            return userRepository.findByLoginName(loginName);
        }catch (Exception ex){
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(),ex.getMessage(),ex);
        }

    }

    @Override
    public User findByPhone(String phone) throws DaoException {
        try {
            return userRepository.findByPhone(phone);
        }catch (Exception ex){
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(),ex.getMessage(),ex);
        }
    }

    @Override
    public User findByEmail(String email) throws DaoException {
        try {
            return userRepository.findByEmail(email);
        }catch (Exception ex){
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(),ex.getMessage(),ex);
        }
    }

    @Override
    public void updateUsersState(State state, Integer... userIds) throws DaoException{
        try {
            userRepository.updateUsersState(state.value(),userIds);
        }catch (Exception ex){
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(),ex.getMessage(),ex);
        }
    }

}
