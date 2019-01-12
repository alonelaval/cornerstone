package com.alonelaval.cornerstone.dao.repository.jpa;

import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepositoryImpl;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepositoryImpl;
import com.alonelaval.cornerstone.entity.EntityAppllation;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 * @author huawei
 * @create 2018-07-08
 **/
//@Rollback
//@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {EntityAppllation.class,JpaApplication.class})
public abstract class ContextAwareTest extends AbstractJUnit4SpringContextTests { }
