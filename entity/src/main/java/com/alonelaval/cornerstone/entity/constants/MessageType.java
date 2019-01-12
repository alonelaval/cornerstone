package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-09-07
 **/
public enum MessageType implements IEnum {

    PLATFORM_MESSAGE(0,"平台消息"),
    ORG_MESSAGE(1,"机构消息");

    private final int value;
    private final String desc;


    @Override
    public int value() {
        return value;
    }

    @Override
    public String desc() {
        return this.desc;
    }

    MessageType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

    public static String typeName() {
        return "消息类型";
    }

    public static MessageType valueOf(Integer value){
        if(value == MessageType.PLATFORM_MESSAGE.value){
            return  MessageType.PLATFORM_MESSAGE;
        }
        else {
            return  MessageType.ORG_MESSAGE;
        }
    }
}
