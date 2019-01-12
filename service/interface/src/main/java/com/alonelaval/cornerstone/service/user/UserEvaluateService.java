package com.alonelaval.cornerstone.service.user;

import com.alonelaval.cornerstone.entity.biz.UserEvaluate;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface UserEvaluateService  extends IBaseService<UserEvaluate,Integer> {
    default UserEvaluate addUserEvaluate(UserEvaluate userEvaluate) throws Exception{
        return this.add(userEvaluate);
    }

}