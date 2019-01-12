package com.alonelaval.cornerstone.dao.repository.jpa.biz;

import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.entity.biz.PlatformShopkeeper;
import org.springframework.stereotype.Repository;

/**
 * @author huawei
 * @create 2018-07-111
 * create by python 
 **/
@Repository
public interface PlatformShopkeeperRepository extends BaseRepository<PlatformShopkeeper,Integer> {

    PlatformShopkeeper findAllByUserId(Integer userId);
}
