package com.alonelaval.cornerstone.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author huawei
 * @create 2018-07-21
 **/
public class SmsCodeMessageCache {

    /**
     * 默认30分钟后验证码失效
     */
    private final Cache<String, String> phoneCodes = CacheBuilder.newBuilder()
            .maximumSize(5000)
            .expireAfterWrite(30,TimeUnit.MINUTES)
            .build();


    private SmsCodeMessageCache(){

    }
    public static SmsCodeMessageCache getInstance() {
        return SmsCodeMessageCacheHolder.instance;
    }

    private static class SmsCodeMessageCacheHolder{
        private static SmsCodeMessageCache instance = new SmsCodeMessageCache();
    }

    public void put(String phone,String code){
        phoneCodes.put(phone,code);
    }
    public void invalidate(String phone){
        phoneCodes.invalidate(phone);
    }
    public boolean verificationCode(String phone,String code){
        String codeCache = phoneCodes.getIfPresent(phone);
        if(null != codeCache  && codeCache.equals(code)){
            return true;
        }
        return  false;
    }
}
