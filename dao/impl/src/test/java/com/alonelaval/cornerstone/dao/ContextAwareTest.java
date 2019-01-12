package com.alonelaval.cornerstone.dao;

import com.alonelaval.cornerstone.dao.repository.jpa.JpaApplication;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepositoryImpl;
import com.alonelaval.cornerstone.entity.EntityAppllation;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author huawei
 * @create 2018-07-08
 **/
//@Rollback
//@Transactional
@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {EntityAppllation.class,JpaApplication.class
        ,DaoImplApplication.class})
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class,basePackages = "com.alonelaval.cornerstone.dao.repository")
@SpringBootApplication(scanBasePackages="com.alonelaval.cornerstone.dao")
@EntityScan("com.alonelaval.cornerstone.entity")
@Slf4j
public abstract class ContextAwareTest extends AbstractJUnit4SpringContextTests { }
