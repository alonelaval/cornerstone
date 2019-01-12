package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * 注册来源
 *
 * @author huawei
 * @create 2018-07-07
 **/
public enum  RegSource implements IEnum {
    IOS(0,"苹果"),
    ANDROID(1,"安卓"),
    PC(2,"电脑"),
    PROMOTION(3,"推广");


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

    RegSource(int value,String desc){
        this.value = value;
        this.desc = desc;
    }
    public static String typeName() {
        return "注册来源";
    }
    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

    public static RegSource valueOf(Integer value) {
        if (value == IOS.value) {
            return IOS;
        } else if(value == ANDROID.value) {
            return ANDROID;
        }else if(value == PROMOTION.value) {
            return PROMOTION;
        }
        return  PC;
    }
}
