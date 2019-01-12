package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-07-21
 **/
public enum PlatformMessageType implements IEnum {

    USER_REG(0,"用户注册"),
    USER_FIND_PWD(1,"找回密码");

    private final  int value;
    private final String desc;

    @Override
    public int value() {
        return value;
    }

    @Override
    public String desc() {
        return this.desc;
    }

    PlatformMessageType(int value, String desc){
        this.value = value;
        this.desc = desc;
    }

    public static String typeName() {
        return "平台短信类型类型";
    }

    public static  PlatformMessageType valueOf(Integer value){
        if(value == USER_REG.value){
            return  USER_REG;
        }
        else{
            return  USER_FIND_PWD;
        }
    }
    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }


}
