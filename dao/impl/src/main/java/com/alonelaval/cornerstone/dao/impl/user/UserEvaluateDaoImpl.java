package com.alonelaval.cornerstone.dao.impl.user;

import com.alonelaval.cornerstone.dao.inter.user.UserEvaluateDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.UserEvaluateRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.UserEvaluateDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.UserEvaluateRepository;
import com.alonelaval.cornerstone.entity.biz.UserEvaluate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="userEvaluateDao")
public class UserEvaluateDaoImpl  extends AbstractBaseDao<UserEvaluate,Integer> implements UserEvaluateDao {

    @Autowired
    UserEvaluateRepository userEvaluateRepository;

    @Override
    protected BaseRepository<UserEvaluate, Integer> getBaseRepository() {
        return userEvaluateRepository;
    }
}
