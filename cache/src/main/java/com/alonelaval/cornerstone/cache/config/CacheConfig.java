package com.alonelaval.cornerstone.cache.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huawei
 * @create 2018-08-12
 **/
@Configuration
public class CacheConfig {
    @Bean
    public ApplicationContext app(@Autowired ApplicationContext applicationContext) {
        return applicationContext;
    }



}
