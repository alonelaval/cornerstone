package com.alonelaval.cornerstone.servce.impl.platform;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.platform.SecretKeyDao;
import com.alonelaval.cornerstone.entity.biz.SecretKey;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.platform.SecretKeyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("secretKeyService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class SecretKeyServiceImpl extends AbstractBaseService<SecretKey,Integer> implements SecretKeyService {
    @Autowired
    SecretKeyDao secretKeyDao;
    

    @Override
    protected IBaseDao<SecretKey,Integer> getBaseDao() {
        return secretKeyDao;
    }
}
