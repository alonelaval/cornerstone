//package com.alonelaval.cornerstone.servce.impl.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
///**
// * @author huawei
// * @create 2018-08-12
// **/
//@Component
//@Slf4j
//public class EventListenerExampleBean {
//
//    public static int counter;
//
//    @EventListener
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        log.info("Increment counter");
//        log.info(ServiceApplicationContextRegister.getApplicationContext().getBean("platformCourseCategoryService").toString());
////        log.info(CourseCategoryCache.getInstance().get(1).toString());
//        counter++;
//    }
//}
