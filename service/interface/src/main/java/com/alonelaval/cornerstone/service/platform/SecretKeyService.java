package com.alonelaval.cornerstone.service.platform;

import com.alonelaval.cornerstone.entity.biz.SecretKey;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface SecretKeyService  extends IBaseService<SecretKey,Integer> {
    default void addSecretKey(SecretKey secretKey) throws Exception{
   }

}