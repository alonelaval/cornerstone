package com.alonelaval.cornerstone.dao.impl.user;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.user.UserInvoiceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.UserInvoiceRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.UserInvoiceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.UserInvoiceRepository;
import com.alonelaval.cornerstone.entity.biz.UserInvoice;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="userInvoiceDao")
public class UserInvoiceDaoImpl  extends AbstractBaseDao<UserInvoice,Integer> implements UserInvoiceDao {

    @Autowired
    UserInvoiceRepository userInvoiceRepository;

    @Override
    protected BaseRepository<UserInvoice, Integer> getBaseRepository() {
        return userInvoiceRepository;
    }

    @Override
    public List<UserInvoice> findAllByUserId(Integer userId) throws DaoException {
        try {
            return userInvoiceRepository.findAllByUserId(userId);
        }catch (Exception e){
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(),e.getMessage(),e);
        }
    }
}
