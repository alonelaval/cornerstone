package com.alonelaval.cornerstone.dao.impl.platform;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.platform.PlatformShopkeeperDao;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.PlatformShopkeeperRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.platform.PlatformShopkeeperDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.PlatformShopkeeperRepository;
import com.alonelaval.cornerstone.entity.biz.PlatformShopkeeper;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="PlatformShopkeeperDao")
public class PlatformShopkeeperDaoImpl  extends AbstractBaseDao<PlatformShopkeeper,Integer> implements PlatformShopkeeperDao {

    @Autowired
    PlatformShopkeeperRepository platformShopkeeperRepository;

    @Override
    protected BaseRepository<PlatformShopkeeper, Integer> getBaseRepository() {
        return platformShopkeeperRepository;
    }

    @Override
    public PlatformShopkeeper findByUserId(Integer userId) throws DaoException {

        try {
            return platformShopkeeperRepository.findAllByUserId(userId);
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }

    }
}
