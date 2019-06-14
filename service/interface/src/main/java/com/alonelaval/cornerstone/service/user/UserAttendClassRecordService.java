package com.alonelaval.cornerstone.service.user;

import com.alonelaval.cornerstone.entity.biz.UserAttendClassRecord;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface UserAttendClassRecordService  extends IBaseService<UserAttendClassRecord,Integer> {
    default UserAttendClassRecord addUserAttendClassRecord(UserAttendClassRecord userAttendClassRecord) throws Exception{
        return  this.add(userAttendClassRecord);
    }

}