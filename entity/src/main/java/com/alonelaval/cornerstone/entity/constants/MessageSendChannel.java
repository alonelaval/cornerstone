package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-09-07
 **/
public enum MessageSendChannel implements IEnum {
    PC(0,"PC"),
    MOBILE(1,"移动端"),
    SMS(2,"短信"),
    EMAIL(3,"邮箱"),
    OTHER(6,"其他");



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

    MessageSendChannel(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

    public  static String typeName() {
        return "消息发送渠道";
    }

    public static MessageSendChannel valueOf(Integer value){
        if(value == MessageSendChannel.PC.value){
            return  MessageSendChannel.PC;
        }
        else if(value == MessageSendChannel.MOBILE.value){
            return  MessageSendChannel.MOBILE;
        }else if(value == MessageSendChannel.SMS.value){
            return  MessageSendChannel.SMS;
        }else if(value == MessageSendChannel.EMAIL.value){
            return  MessageSendChannel.EMAIL;
        }
        else {
            return  MessageSendChannel.OTHER;
        }
    }
}
