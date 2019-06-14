package com.alonelaval.common;

/**
 * @author huawei
 * @create 2018-09-09
 **/
public class EventBusTest {
    public static void main(String[] args) {

        DataObserver1 observer1 = new DataObserver1();
        DataObserver2 observer2 = new DataObserver2();
        DataObserver3 observer3 = new DataObserver3();

        EventBusCenterTest.register(observer1);
        EventBusCenterTest.register(observer2);
        EventBusCenterTest.register(observer3);

        System.out.println("============   start  ====================");

        // 只有注册的参数类型为String的方法会被调用
        EventBusCenterTest.post("post string method");
        EventBusCenterTest.post(123);

        System.out.println("============ after unregister ============");
        // 注销observer2
        EventBusCenterTest.unregister(observer2);
        EventBusCenterTest.post("post string method");
        EventBusCenterTest.post(123);

        System.out.println("============    end           =============");

    }
}
