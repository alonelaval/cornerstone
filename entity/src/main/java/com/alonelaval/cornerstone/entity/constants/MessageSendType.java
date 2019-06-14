package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-09-07
 **/
public enum MessageSendType implements IEnum {

    DAILY(0,"每天发送"),
    CRONTAB(1,"定时任务"),
    MANUAL(2,"手动发送");


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

    MessageSendType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

    public static String typeName() {
        return "发送类型";
    }

    public static MessageSendType valueOf(Integer value){
        if(value == MessageSendType.DAILY.value){
            return  MessageSendType.DAILY;
        }
        else if(value == MessageSendType.CRONTAB.value){
            return  MessageSendType.CRONTAB;
        }
        else {
            return  MessageSendType.MANUAL;
        }
    }
}
