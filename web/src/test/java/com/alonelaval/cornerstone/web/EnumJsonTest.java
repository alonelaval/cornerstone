package com.alonelaval.cornerstone.web;

import com.alibaba.fastjson.JSONObject;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;

/**
 * @author huawei
 * @create 2018-07-21
 **/
public class EnumJsonTest {

    public static void main(String[] args) {

        ExceptionType ex  = ExceptionType.DAO_EXCEPTION;

        System.out.println(JSONObject.toJSONString(ex));

    }
}
