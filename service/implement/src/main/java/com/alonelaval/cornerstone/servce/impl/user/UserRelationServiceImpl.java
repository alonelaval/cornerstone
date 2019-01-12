package com.alonelaval.cornerstone.servce.impl.user;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.UserRelationDao;
import com.alonelaval.cornerstone.entity.biz.UserRelation;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.user.UserRelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("userRelationService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UserRelationServiceImpl extends AbstractBaseService<UserRelation,Integer> implements UserRelationService {
    @Autowired
    UserRelationDao userRelationDao;
    

    @Override
    protected IBaseDao<UserRelation,Integer> getBaseDao() {
        return userRelationDao;
    }
}
