package com.alonelaval.cornerstone.dao.impl.user;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.UserAddresseeTagDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.UserAddresseeTagRepository;
import com.alonelaval.cornerstone.entity.biz.UserAddresseeTag;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="userAddresseeTagDao")
public class UserAddresseeTagDaoImpl  extends AbstractBaseDao<UserAddresseeTag,Integer> implements UserAddresseeTagDao {

    @Autowired
    UserAddresseeTagRepository userAddresseeTagRepository;

    @Override
    protected BaseRepository<UserAddresseeTag, Integer> getBaseRepository() {
        return userAddresseeTagRepository;
    }

    @Override
    public void deleteAllByAddresseeId(Integer addresseeId) throws DaoException {
        try {
            userAddresseeTagRepository.deleteAllByAddresseeId(State.DELETE.value(),addresseeId);
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }
}
