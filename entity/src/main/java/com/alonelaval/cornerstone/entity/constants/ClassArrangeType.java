package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-08-29
 **/
public enum ClassArrangeType implements IEnum {

    MANUAL(0,"手动排课"),
    AUTOMATE(1,"自动排课");

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

    ClassArrangeType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "排课类型";
    }

    @Override
    public ClassArrangeType value(int value) {
        return valueOf(value);
    }

    public static ClassArrangeType valueOf(Integer value) {
        if (value == MANUAL.value) {
            return MANUAL;
        }
        return AUTOMATE;
    }
}
