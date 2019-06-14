package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * 性别
 *
 * @author huawei
 * @create 2018-07-07
 **/
public enum  Gender  implements  IEnum{
    /**
     * 男
     */
    MALE(0,"男"),
    /**
     * 女
     */
    FEMALE(1,"女"),
    /***
     * 其他
     */
    OTHER(2,"其他");


    private final  int value;
    private final  String desc;

    @Override
    public int value() {
        return value;
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

    @Override
    public String desc() {
        return desc;
    }


    public static String typeName() {
        return "性别";
    }

    Gender(int value,String desc){
        this.value = value;
        this.desc =desc;
    }
    public static  Gender valueOf(Integer value){
        if(value == MALE.value){
            return  MALE;
        }
        else if(FEMALE.value == value){
            return  FEMALE;
        }

        return OTHER;
    }
}

