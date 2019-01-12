package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-07-23
 **/
public enum  DealType implements IEnum {

    BUY(0,"购买"),
    RENEW(1,"续费"),
    DONATE(2,"赠送"),
    EXPERIENCE(3,"体验版");

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

    DealType(int value, String desc){
        this.value = value;
        this.desc = desc;
    }

    public static String typeName() {
        return "交易类型";
    }
    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

    public static  DealType valueOf(Integer value){
        if(value == BUY.value){
            return  BUY;
        }
        else if(RENEW.value == value){
            return  RENEW;
        }
        else if(DONATE.value == value){
            return  DONATE;
        }

        return EXPERIENCE;
    }
}
