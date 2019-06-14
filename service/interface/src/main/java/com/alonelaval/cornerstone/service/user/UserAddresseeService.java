package com.alonelaval.cornerstone.service.user;

import com.alonelaval.cornerstone.entity.biz.UserAddressee;
import com.alonelaval.cornerstone.entity.model.UserAddresseeModel;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface UserAddresseeService  extends IBaseService<UserAddressee,Integer> {
    default UserAddressee addUserAddressee(UserAddressee userAddressee) throws Exception{
        return  this.add(userAddressee);
   }
    UserAddressee addUserAddress(UserAddresseeModel userAddresseeModel)throws  Exception;

    List<UserAddressee> findAllByUserId(Integer userId)throws  Exception;

}