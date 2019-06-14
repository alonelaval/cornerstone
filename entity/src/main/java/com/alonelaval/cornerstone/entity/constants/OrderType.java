package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-08-05
 **/
public enum OrderType implements IEnum {
    PLATFORM_ORDER(0,"平台订单"),
    ORG_ORDER(1,"机构订单");
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

    OrderType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "订单类型";
    }

    public static OrderType valueOf(Integer value) {

        if(PLATFORM_ORDER.value() ==value) {
            return PLATFORM_ORDER;
        }
        else{
            return ORG_ORDER;
        }
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }
}
