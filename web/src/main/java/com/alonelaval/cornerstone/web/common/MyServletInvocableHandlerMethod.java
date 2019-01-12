package com.alonelaval.cornerstone.web.common;

import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import java.lang.reflect.Method;

/**
 * @author huawei
 * @create 2018-07-24
 * test
 **/
public class MyServletInvocableHandlerMethod extends ServletInvocableHandlerMethod {
    public MyServletInvocableHandlerMethod(Object handler, Method method) {
        super(handler, method);
    }
}
