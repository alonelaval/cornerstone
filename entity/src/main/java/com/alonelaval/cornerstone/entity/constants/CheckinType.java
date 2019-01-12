package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-09-04
 **/
public enum CheckinType implements IEnum {

    IOS(0,"苹果"),
    ANDROID(1,"安卓"),
    APPLET(2,"小程序"),
    PC(3,"电脑"),
    OTHER(4,"其他");

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

    CheckinType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "签到的客户端";
    }

    @Override
    public CheckinType value(int value) {
        return valueOf(value);
    }

    public static CheckinType valueOf(Integer value) {
        if (IOS.value == value) {
            return IOS;
        } else if (ANDROID.value == value) {
            return ANDROID;
        }else if (APPLET.value == value) {
            return APPLET;
        }else if (PC.value == value) {
            return PC;
        }
        return OTHER;
    }

}
