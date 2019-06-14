package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-07-31
 **/
public enum  VisitType implements IEnum {

    SATISFACTION(0,"满意度调查"),
    COURSE_FOLLOW(1,"课程跟进"),
    RENEW_FOLLOW(2,"续费跟进"),
    OTHER(3,"其他");


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
        return "回访类型";
    }

    VisitType(int value,String desc){
        this.value = value;
        this.desc =desc;
    }

    public static  VisitType valueOf(Integer value){
        if(value == SATISFACTION.value){
            return  SATISFACTION;
        }
        else if(COURSE_FOLLOW.value == value){
            return  COURSE_FOLLOW;
        }else if(RENEW_FOLLOW.value == value){
            return  RENEW_FOLLOW;
        }

        return OTHER;
    }
}
