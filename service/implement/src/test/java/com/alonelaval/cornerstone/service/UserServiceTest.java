package com.alonelaval.cornerstone.service;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.dao.DaoImplApplication;
import com.alonelaval.cornerstone.dao.repository.jpa.JpaApplication;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepositoryImpl;
import com.alonelaval.cornerstone.entity.EntityAppllation;
import com.alonelaval.cornerstone.entity.biz.User;
import com.alonelaval.cornerstone.entity.model.UserModel;
import com.alonelaval.cornerstone.servce.impl.ServiceImplApplication;
import com.alonelaval.cornerstone.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {EntityAppllation.class,JpaApplication.class,DaoImplApplication.class,ServiceImplApplication.class})
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class,basePackages = "com.alonelaval.cornerstone.dao.repository")
@SpringBootApplication(scanBasePackages="com.alonelaval")
@EntityScan("com.alonelaval.cornerstone.entity")
@Slf4j
public class UserServiceTest {
//


    @Configuration
    static class ContextConfiguration {

            @Bean
            PasswordEncoder passwordEncoder(){
                return  new BCryptPasswordEncoder();
            }
    }

    @Autowired
    UserService userService;

    @Test
    public void providesFindOneWithOptional() throws Exception {
//        User user = User.userBuilder().loginName("11").phone("111").loginPassword("11").userRealName("huawei").build();
//        user.setState(State.DELETE);
//         userService.addUser(user);

        Page<User> page = userService.findUser(new UserModel(),new Page(10));
        System.out.println(page);
        page = userService.findByModelAndPage(null,new Page(10));
        System.out.println(page);
//        String userId  = user.getId();
//        user.setUserId(0);
//        System.out.println(user.getId());
//        user.setId(userId);
//        System.out.println(user.getUserId());
//        System.out.println(user.getLastUpdateTime());

    }
}
