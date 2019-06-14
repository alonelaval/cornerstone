package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-08-12
 **/
public enum CourseStartType implements IEnum {

    ONE_START(0, "1人立即开班"),
    ASSIGN_START(1,"指定人数开班"),
    FULL_START(2, "满员开班");

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

    CourseStartType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "开班方式";
    }

    public static CourseStartType valueOf(Integer value){
        if(value == ONE_START.value){
            return  ONE_START;
        }else if(ASSIGN_START.value==value)
        {
            return  ASSIGN_START;
        }
        else{
            return  FULL_START;
        }
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

}
