package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author
 * @create 2018-07-14
 **/
public enum PermissionType implements IEnum {
    API(0,"接口"),
    SERVICE(1,"服务"),
    MENU(2,"菜单");

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

    PermissionType(int value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public  static String typeName() {
        return "资源类型";
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

    public static PermissionType valueOf(Integer value) {
        if (value == API.value) {
            return API;
        } else if(value == SERVICE.value) {
            return SERVICE;
        }
        return  MENU;
    }
}
