package com.alonelaval.cornerstone.service.platform;

import com.alonelaval.cornerstone.entity.biz.Org;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.biz.PlatformShopkeeper;
import com.alonelaval.cornerstone.entity.biz.User;
import com.alonelaval.cornerstone.service.IBaseService;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface PlatformShopkeeperService  extends IBaseService<PlatformShopkeeper,Integer> {
    default PlatformShopkeeper addPlatformShopkeeper(PlatformShopkeeper platformShopkeeper) throws Exception{
    	return this.add(platformShopkeeper);
   }
    PlatformShopkeeper addShopkeeper(Org org, User user, OrgEmployee orgEmployee)throws  Exception;
    PlatformShopkeeper findByUserId(Integer userId) throws  Exception;
}