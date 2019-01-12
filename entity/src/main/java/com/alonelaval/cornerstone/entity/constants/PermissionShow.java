package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-07-14
 **/
public enum  PermissionShow implements IEnum {

    SHOW(0,"展示"),
    HIDE(1,"隐藏");

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

    PermissionShow(int value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public static String typeName() {
        return "资源是否显示";
    }


    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

    public static PermissionShow valueOf(Integer value) {
        if (value == SHOW.value) {
            return SHOW;
        } else {
            return HIDE;
        }
    }
}
