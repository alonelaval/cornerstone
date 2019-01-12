package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author
 * @create 2018-07-30
 **/
public enum OrgAccountType implements IEnum {

    MAIN_ACCOUNT(0,"主账号"),
    SUB_ACCOUNT(1,"子账号");

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

    OrgAccountType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

    public static String typeName() {
        return "机构账号类型";
    }

    public static OrgAccountType valueOf(Integer value){
        if(value == OrgAccountType.MAIN_ACCOUNT.value){
            return  OrgAccountType.MAIN_ACCOUNT;
        }
        else{
            return  OrgAccountType.SUB_ACCOUNT;
        }
    }
}
