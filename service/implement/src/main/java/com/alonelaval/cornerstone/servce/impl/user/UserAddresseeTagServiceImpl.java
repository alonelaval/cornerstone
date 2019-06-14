package com.alonelaval.cornerstone.servce.impl.user;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.UserAddresseeTagDao;
import com.alonelaval.cornerstone.entity.biz.UserAddresseeTag;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.user.UserAddresseeTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("userAddresseeTagService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UserAddresseeTagServiceImpl extends AbstractBaseService<UserAddresseeTag,Integer> implements UserAddresseeTagService {
    @Autowired
    UserAddresseeTagDao userAddresseeTagDao;
    

    @Override
    protected IBaseDao<UserAddresseeTag,Integer> getBaseDao() {
        return userAddresseeTagDao;
    }

    @Override
    public void deleteAllByAddresseeId(Integer addresseeId) throws Exception {
        userAddresseeTagDao.deleteAllByAddresseeId(addresseeId);
    }
}
