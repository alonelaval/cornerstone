package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author
 * @create 2018-07-30
 **/
public enum OrgResourceType implements IEnum {

    BUSINESS_LICENSE(0,"营业执照"),
    TRADE_LICENSE(1,"行业许可证"),
    OTHER(3,"其他文件");
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

    OrgResourceType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }


    public static String typeName() {
        return "机构资源类型";
    }

    public static OrgResourceType valueOf(Integer value){
        if(value == BUSINESS_LICENSE.value){
            return  BUSINESS_LICENSE;
        }
        else if(OTHER.value == value){
            return OTHER;
        }
        else{
            return  TRADE_LICENSE;
        }
    }
}
