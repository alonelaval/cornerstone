package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-08-29
 **/
public enum  ClassGradeType implements IEnum {

    FIXATION(0,"固定"),
    TEMPORARY(1,"临时");

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

    ClassGradeType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "班级类型";
    }

    @Override
    public ClassGradeType value(int value) {
        return valueOf(value);
    }

    public static ClassGradeType valueOf(Integer value) {
        if (value == FIXATION.value) {
            return FIXATION;
        }
        return TEMPORARY;
    }
}