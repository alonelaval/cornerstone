package com.alonelaval.cornerstone.dao.impl.user;

import com.alonelaval.cornerstone.dao.inter.user.UserStudentDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.UserStudentRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.UserStudentDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.UserStudentRepository;
import com.alonelaval.cornerstone.entity.biz.UserStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="userStudentDao")
public class UserStudentDaoImpl extends AbstractBaseDao<UserStudent,Integer> implements UserStudentDao {

    @Autowired
    UserStudentRepository userStudentRepository;

    @Override
    protected BaseRepository<UserStudent, Integer> getBaseRepository() {
        return userStudentRepository;
    }
}
