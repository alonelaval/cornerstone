package com.alonelaval.cornerstone.web.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.annotation.PreDestroy;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

/**
 * @author huawei
 * @create 2018-08-11
 **/

@Order(1)
@Slf4j
public class YczServletContextListener implements ServletContextListener {


    public void onStartup(ServletContext servletContext) throws ServletException {
//        log.info(ContextLoader.getCurrentWebApplicationContext().getBean("platformCourseCategoryService").toString());
//        log.info(CourseCategoryCache.getInstance().get(1).toString());
    }

    @PreDestroy
    public void onDestroy() throws Exception {
//        log.info(ContextLoader.getCurrentWebApplicationContext().getBean("platformCourseCategoryService").toString());
//        log.info(CourseCategoryCache.getInstance().get(1).toString());
//        log.info("Spring Container is destroyed!");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

//        log.info(ContextLoader.getCurrentWebApplicationContext().getBean("platformCourseCategoryService").toString());
//        log.info(CourseCategoryCache.getInstance().get(1).toString());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        log.info(ContextLoader.getCurrentWebApplicationContext().getBean("platformCourseCategoryService").toString());
//        log.info(CourseCategoryCache.getInstance().get(1).toString());
//        log.info("Spring Container is destroyed!");
    }
}
