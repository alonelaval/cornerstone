package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-08-29
 **/
public enum  ClassState implements IEnum {

    PREPARE(0,"准备中"),
    UNDERWAY(1,"进行中"),
    FINISH(2,"结束"),
    DISABLED(3,"作废"),
    DELETE(4,"删除");

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

    ClassState(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "班级状态";
    }

    @Override
    public ClassState value(int value) {
        return valueOf(value);
    }

    public static ClassState valueOf(Integer value) {
        if (value == PREPARE.value) {
            return PREPARE;
        } else if (UNDERWAY.value == value) {
            return UNDERWAY;
        } else if (FINISH.value == value) {
            return FINISH;
        } else if (DISABLED.value == value) {
            return DISABLED;
        }
        return DELETE;
    }
}
