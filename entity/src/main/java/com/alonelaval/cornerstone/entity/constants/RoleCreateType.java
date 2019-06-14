package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-07-14
 **/
public enum RoleCreateType implements IEnum {
    /**
     * 平台分配
     */
    PLATFORM_ALLOCATION(0, "平台分配"),
    /***
     * 机构创建
     */
    ORG_CREATION(1, "机构创建"),
    /***
     * 平台创建
     */
    PLATFORM_CREATION(2, "平台创建");


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

    RoleCreateType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "角色所属类型";
    }

    public static RoleCreateType valueOf(Integer value){
        if(value == RoleCreateType.PLATFORM_ALLOCATION.value){
            return  RoleCreateType.PLATFORM_ALLOCATION;
        }
        else if(value == RoleCreateType.ORG_CREATION.value){
            return  RoleCreateType.ORG_CREATION;
        }else{
            return  RoleCreateType.PLATFORM_CREATION;
        }
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

}
