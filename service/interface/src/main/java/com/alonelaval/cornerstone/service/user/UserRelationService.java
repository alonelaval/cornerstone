package com.alonelaval.cornerstone.service.user;

import com.alonelaval.cornerstone.entity.biz.UserRelation;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface UserRelationService  extends IBaseService<UserRelation,Integer> {
    default void addUserRelation(UserRelation userRelation) throws Exception{
   }

}