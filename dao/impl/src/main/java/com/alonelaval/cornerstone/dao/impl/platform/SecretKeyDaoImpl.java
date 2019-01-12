package com.alonelaval.cornerstone.dao.impl.platform;

import com.alonelaval.cornerstone.dao.inter.platform.SecretKeyDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.SecretKeyRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.platform.SecretKeyDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.SecretKeyRepository;
import com.alonelaval.cornerstone.entity.biz.SecretKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="secretKeyDao")
public class SecretKeyDaoImpl  extends AbstractBaseDao<SecretKey,Integer> implements SecretKeyDao {

    @Autowired
    SecretKeyRepository secretKeyRepository;

    @Override
    protected BaseRepository<SecretKey, Integer> getBaseRepository() {
        return secretKeyRepository;
    }
}
