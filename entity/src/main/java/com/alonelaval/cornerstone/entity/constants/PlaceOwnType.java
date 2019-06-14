package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-08-12
 **/
public enum  PlaceOwnType  implements IEnum {
    /**
     * 租凭
     */
    LEASE(0, "租凭"),
    /***
     * 自拥
     */
    OWNER(1, "自拥");


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

    PlaceOwnType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "拥有类型";
    }

    public static PlaceOwnType valueOf(Integer value){
        if(value == LEASE.value){
            return  LEASE;
        }
        else{
            return  OWNER;
        }
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

}
