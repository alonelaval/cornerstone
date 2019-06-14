package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-07-28
 **/
public enum  AuditState implements IEnum {

    WAIT_AUDIT(0,"等待审核"),
    NOT_PASS(1,"审核不通过"),
    PASS(2,"审核通过");

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

    AuditState(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static String typeName() {
        return "审核状态";
    }

    @Override
    public AuditState value(int value) {
        return valueOf(value);
    }

    public static AuditState valueOf(Integer value) {
        if (value == WAIT_AUDIT.value) {
            return WAIT_AUDIT;
        } else if (NOT_PASS.value == value) {
            return NOT_PASS;
        }
        return PASS;
    }
}