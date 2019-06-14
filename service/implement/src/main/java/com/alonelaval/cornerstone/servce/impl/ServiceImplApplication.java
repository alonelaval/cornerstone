package com.alonelaval.cornerstone.servce.impl;

import com.alonelaval.cornerstone.dao.DaoImplApplication;
import com.alonelaval.cornerstone.dao.repository.jpa.JpaApplication;
import com.alonelaval.cornerstone.entity.EntityAppllation;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;


/**
 * @author huawei
 * @create 2018-07-12
 **/
@SpringBootApplication(scanBasePackages="com.alonelaval.*")
@EntityScan("com.alonelaval.cornerstone.entity")
public class ServiceImplApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(EntityAppllation.class,JpaApplication.class, DaoImplApplication.class)
                .run(args);
    }
}

