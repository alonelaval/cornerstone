package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author
 * @create 2018-08-06
 **/
public enum OrgState implements IEnum {

    WAITING(0,"等待开业"),
    OPERATING(1,"营业中"),
    SUSPEND(2,"暂停营业"),
    CLOSED(3,"注销"),
    DISABLED(4,"禁用"),
    DELETE(5,"删除");


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

    OrgState(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "机构状态";
    }

    public static OrgState valueOf(Integer value) {

        if(OPERATING.value() ==value) {
            return OPERATING;
        }
        else
        if(SUSPEND.value() ==value) {
            return SUSPEND;
        }
        else
        if(CLOSED.value() ==value) {
            return CLOSED;
        }
        else
        if(DISABLED.value() ==value) {
            return DISABLED;
        }
        else
        if(WAITING.value() ==value) {
            return WAITING;
        }
        else{
            return DELETE;
        }
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }
}
