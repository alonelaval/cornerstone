package com.alonelaval.cornerstone.entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Configuration
@EntityScan("com.alonelaval.cornerstone.entity.biz")
@SpringBootApplication
public class EntityAppllation extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(EntityAppllation.class, args);
    }
}
