package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-08-12
 **/
public enum CourseType implements IEnum {

    FORMAL(0, "正式课"),
    EXPERIENCE(1,"体验课");


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

    CourseType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "课程类型";
    }

    public static CourseType valueOf(Integer value){
        if(value == FORMAL.value){
            return  FORMAL;
        }
        else{
            return  EXPERIENCE;
        }
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

}
