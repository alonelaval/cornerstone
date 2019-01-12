package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-07-14
 **/
public enum  RoleOwnType implements IEnum {
    /**
     * 平台角色
     */
    PLATFORM_ROLE(0, "平台角色"),
    /***
     * 机构角色
     */
    ORG_ROLE(1, "机构角色"),
    /***
     * 用户角色
     */
    USER_ROLE(2, "用户角色");

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

    RoleOwnType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "角色所属类型";
    }

    public static RoleOwnType valueOf(Integer value){
        if(value == RoleOwnType.PLATFORM_ROLE.value){
            return  RoleOwnType.PLATFORM_ROLE;
        }
        else if(value == RoleOwnType.ORG_ROLE.value){
            return  RoleOwnType.ORG_ROLE;
        }else{
            return  RoleOwnType.USER_ROLE;
        }
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

}
