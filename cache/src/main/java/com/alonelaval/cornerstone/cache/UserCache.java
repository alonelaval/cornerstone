package com.alonelaval.cornerstone.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.alonelaval.cornerstone.cache.config.CacheApplicationContextRegister;
import com.alonelaval.cornerstone.service.user.UserService;
import org.springframework.security.core.Authentication;

import java.util.concurrent.TimeUnit;

/**
 * @author huawei
 * @create 2018-07-13
 **/
public class UserCache {

    private final com.google.common.cache.LoadingCache<String,Authentication> userCaches = CacheBuilder.newBuilder()
            .maximumSize(5000)
            .refreshAfterWrite(30,TimeUnit.MINUTES)
            .build(
                    new CacheLoader<String, Authentication>() {
                        @Override
                        public Authentication load(String name) throws Exception {
                            return null;
                        }
                    });


    private UserCache(){
        userService = (UserService)  CacheApplicationContextRegister.getApplicationContext()
                .getBean("userService");
    }
    public static UserCache getInstance() {
        return UserCacheHolder.instance;
    }

    private static class UserCacheHolder{
        private static UserCache instance = new UserCache();
    }
    public void put(String userName,Authentication userDetails){
        userCaches.put(userName,userDetails);
    }
    public Authentication get(String userName){
        return userCaches.getIfPresent(userName);
    }
    public void invalidate(String userName){
        userCaches.invalidate(userName);
    }


    private UserService userService;

    public static void main(String[] args) {

        System.out.println(UserCache.getInstance().get("111"));
    }
}
