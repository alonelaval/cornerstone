package com.alonelaval.cornerstone.service.user;

import com.alonelaval.cornerstone.entity.biz.UserAddresseeTag;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface UserAddresseeTagService  extends IBaseService<UserAddresseeTag,Integer> {
    default UserAddresseeTag addUserAddresseeTag(UserAddresseeTag userAddresseeTag) throws Exception{
            return  this.add(userAddresseeTag);
   }
    void deleteAllByAddresseeId(Integer addresseeId)throws  Exception;
}