package com.alonelaval.cornerstone.servce.impl.user;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.UserEvaluateDao;
import com.alonelaval.cornerstone.entity.biz.UserEvaluate;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.user.UserEvaluateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("userEvaluateService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UserEvaluateServiceImpl extends AbstractBaseService<UserEvaluate,Integer> implements UserEvaluateService {
    @Autowired
    UserEvaluateDao userEvaluateDao;
    

    @Override
    protected IBaseDao<UserEvaluate,Integer> getBaseDao() {
        return userEvaluateDao;
    }
}
