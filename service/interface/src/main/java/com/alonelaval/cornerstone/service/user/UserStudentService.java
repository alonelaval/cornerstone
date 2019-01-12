package com.alonelaval.cornerstone.service.user;

import com.alonelaval.cornerstone.entity.biz.UserStudent;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface UserStudentService  extends IBaseService<UserStudent,Integer> {
    default UserStudent addUserStudent(UserStudent userStudent) throws Exception{
    	return this.add(userStudent);
   }


}