package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-07-29
 **/
public enum  InvoiceIssueType implements IEnum {
    PERSONAL(0, "个人"),
    COMPANY(1, "企业");


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

    InvoiceIssueType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "发票开具类型";
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }


    public static InvoiceIssueType valueOf(Integer value) {

        if (value == PERSONAL.value) {
            return PERSONAL;
        } else {
            return COMPANY;
        }
    }
}
