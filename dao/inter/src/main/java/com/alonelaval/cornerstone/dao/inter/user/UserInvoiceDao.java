package com.alonelaval.cornerstone.dao.inter.user;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.UserInvoice;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface UserInvoiceDao  extends IBaseDao<UserInvoice,Integer> {
     List<UserInvoice> findAllByUserId(Integer userId) throws DaoException;
}
