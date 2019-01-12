package com.alonelaval.common;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * @author huawei
 * @create 2018-09-09
 **/
public class EventBusCenterTest {


    private static EventBus eventBus = new EventBus("aaa");

    private EventBusCenterTest() {

    }

    public static EventBus getInstance() {
        return eventBus;
    }

    public static void register(Object obj) {
        eventBus.register(obj);
    }

    public static void unregister(Object obj) {
        eventBus.unregister(obj);
    }

    public static void post(Object obj) {
        eventBus.post(obj);
    }
}


class DataObserver1 {

    /**
     * 只有通过@Subscribe注解的方法才会被注册进EventBus
     * 而且方法有且只能有1个参数
     *
     * @param msg
     */
    @Subscribe
    public void func(String msg) {
        System.out.println("DataObserver1 String msg: " + msg);
    }

}

class DataObserver2 {

    /**
     * 只有通过@Subscribe注解的方法才会被注册进EventBus
     * 而且方法有且只能有1个参数
     *
     * @param msg
     */
    @Subscribe
    public void func(Integer msg) {
        System.out.println("DataObserver2 Integer msg: " + msg);
    }
}
class DataObserver3 {

    /**
     * 只有通过@Subscribe注解的方法才会被注册进EventBus
     * 而且方法有且只能有1个参数
     *
     * @param msg
     */
    @Subscribe
    public void func(String msg) {
        System.out.println("DataObserver3 String msg: " + msg);
    }

}



