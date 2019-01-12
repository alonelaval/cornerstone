package com.alonelaval.cornerstone.dao;

import com.alonelaval.cornerstone.dao.repository.jpa.JpaApplication;
import com.alonelaval.cornerstone.entity.EntityAppllation;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@SpringBootApplication(scanBasePackages="com.alonelaval*")
@EntityScan("com.alonelaval.cornerstone.entity")
public class DaoInterApplication {
    public static void main(String[] args) {
//        SpringApplication.run(DaoApplication.class);
        new SpringApplicationBuilder()
//                .bannerMode(Banner.Mode.CONSOLE)
                .sources(EntityAppllation.class,JpaApplication.class, DaoInterApplication.class)
                .run(args);
    }
}
