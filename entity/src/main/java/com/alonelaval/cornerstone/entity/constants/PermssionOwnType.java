package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author
 * @create 2018-07-14
 **/
public enum PermssionOwnType implements IEnum {
    /**
     * 平台资源
     */
    PLATFORM_PERMSSION(0,"平台资源"),
    /***
     * 机构资源
     */
    ORG_PERMSSION(1,"机构资源"),

    /***
     *
     */
    USER_PERMSSION(2,"普通资源");


    private final  int value;
    private final String desc;

    @Override
    public int value() {
        return value;
    }

    @Override
    public String desc() {
        return this.desc;
    }

    PermssionOwnType(int value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public static String typeName() {
        return "资源所属类型";
    }

    public static PermssionOwnType valueOf(Integer value){
        if(value == PermssionOwnType.PLATFORM_PERMSSION.value){
            return  PermssionOwnType.PLATFORM_PERMSSION;
        }
        else if(value == PermssionOwnType.ORG_PERMSSION.value){
            return  PermssionOwnType.ORG_PERMSSION;
        }else{
            return  PermssionOwnType.USER_PERMSSION;
        }
    }
    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

}
