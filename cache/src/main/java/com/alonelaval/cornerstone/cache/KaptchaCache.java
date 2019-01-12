package com.alonelaval.cornerstone.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author huawei
 * @create 2018-07-21
 **/
public class KaptchaCache {

    /**
     * 默认30分钟后验证码失效
     */
    private final Cache<String, String> kaptchas = CacheBuilder.newBuilder()
            .maximumSize(5000)
            .expireAfterWrite(30,TimeUnit.MINUTES)
            .build();


    private KaptchaCache(){

    }
    public static KaptchaCache getInstance() {
        return KaptchaCacheCacheHolder.instance;
    }

    private static class KaptchaCacheCacheHolder{
        private static KaptchaCache instance = new KaptchaCache();
    }

    public void put(String code){
        kaptchas.put(code,"");
    }
    public void invalidate(String code){
        kaptchas.invalidate(code);
    }
    public boolean verificationCode(String code){
        String codeCache = kaptchas.getIfPresent(code);
        if(null != codeCache){
            this.invalidate(code);
            return true;
        }
        return  false;
    }
}
