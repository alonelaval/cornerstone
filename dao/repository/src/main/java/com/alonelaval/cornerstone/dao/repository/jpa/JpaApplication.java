package com.alonelaval.cornerstone.dao.repository.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@EnableAutoConfiguration
@SpringBootApplication
public class JpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class);
//        new SpringApplicationBuilder()
////                .bannerMode(Banner.Mode.CONSOLE)
//                .sources(EntityAppllation.class,JpaApplication.class)
//                .run(args);
    }
}
