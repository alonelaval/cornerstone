package com.alonelaval.cornerstone.web;

//import com.alonelaval.cornerstone.dao.DaoApplication;

import com.alonelaval.cornerstone.dao.repository.jpa.JpaApplication;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepositoryImpl;
import com.alonelaval.cornerstone.entity.EntityAppllation;
import com.alonelaval.cornerstone.servce.impl.ServiceImplApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class,basePackages = "com.alonelaval.cornerstone.dao.repository")
@SpringBootApplication()
@EntityScan("com.alonelaval.cornerstone.entity")
public class WebApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(EntityAppllation.class,JpaApplication.class,ServiceImplApplication.class,WebApplication.class)
                .run(args);
    }
}
