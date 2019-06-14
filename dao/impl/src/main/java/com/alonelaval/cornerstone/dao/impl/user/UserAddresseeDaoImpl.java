package com.alonelaval.cornerstone.dao.impl.user;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.user.UserAddresseeDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.UserAddresseeRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.UserAddresseeDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.UserAddresseeRepository;
import com.alonelaval.cornerstone.entity.biz.UserAddressee;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="userAddresseeDao")
public class UserAddresseeDaoImpl  extends AbstractBaseDao<UserAddressee,Integer> implements UserAddresseeDao {

    @Autowired
    UserAddresseeRepository userAddresseeRepository;

    @Override
    protected BaseRepository<UserAddressee, Integer> getBaseRepository() {
        return userAddresseeRepository;
    }

    @Override
    public List<UserAddressee> findAllByUserId(Integer userId) throws DaoException {
        try {
            return userAddresseeRepository.findAllByUserId(userId);
        }catch (Exception e){
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(),e.getMessage(),e);
        }
    }
}
