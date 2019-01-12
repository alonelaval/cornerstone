package com.alonelaval.common.message;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author huawei
 * @create 2018-07-21
 **/
public class SmsCodeGenerator {

    public  final  static String generateCode(){
        return RandomStringUtils.random(6,"1234567890");
    }

    public SmsCodeGenerator getInstance(){
        return  SmsCodeGeneratorHolder.instance;
    }

    private static class  SmsCodeGeneratorHolder {
        private static  final  SmsCodeGenerator instance = new SmsCodeGenerator();
    }

    public static void main(String[] args) {
        System.out.println(SmsCodeGenerator.generateCode());
    }
}
