package com.alonelaval.cornerstone.dao.impl.user;

import com.alonelaval.cornerstone.dao.inter.user.UserAttendClassRecordDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.UserAttendClassRecordRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.UserAttendClassRecordDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.UserAttendClassRecordRepository;
import com.alonelaval.cornerstone.entity.biz.UserAttendClassRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="userAttendClassRecordDao")
public class UserAttendClassRecordDaoImpl  extends AbstractBaseDao<UserAttendClassRecord,Integer> implements UserAttendClassRecordDao {

    @Autowired
    UserAttendClassRecordRepository userAttendClassRecordRepository;

    @Override
    protected BaseRepository<UserAttendClassRecord, Integer> getBaseRepository() {
        return userAttendClassRecordRepository;
    }
}
