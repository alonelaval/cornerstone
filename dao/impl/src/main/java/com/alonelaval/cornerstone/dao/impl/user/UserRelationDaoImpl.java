package com.alonelaval.cornerstone.dao.impl.user;

import com.alonelaval.cornerstone.dao.inter.user.UserRelationDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.UserRelationRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.UserRelationDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.UserRelationRepository;
import com.alonelaval.cornerstone.entity.biz.UserRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="userRelationDao")
public class UserRelationDaoImpl  extends AbstractBaseDao<UserRelation,Integer> implements UserRelationDao {

    @Autowired
    UserRelationRepository userRelationRepository;

    @Override
    protected BaseRepository<UserRelation, Integer> getBaseRepository() {
        return userRelationRepository;
    }
}
