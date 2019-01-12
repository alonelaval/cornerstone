package com.alonelaval.cornerstone.service.user;

import com.alonelaval.cornerstone.entity.biz.UserInvoice;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface UserInvoiceService extends IBaseService<UserInvoice, Integer> {
    default UserInvoice addUserInvoice(UserInvoice userInvoice) throws Exception {
        return this.add(userInvoice);
    }

    void deleteByInvoiceIds(List<Integer> invoiceIds) throws Exception;

    List<UserInvoice> findInvoicesByUserId(Integer userId)throws  Exception;
}