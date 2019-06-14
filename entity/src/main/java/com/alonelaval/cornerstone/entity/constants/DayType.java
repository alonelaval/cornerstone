package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-08-10
 **/
public enum  DayType implements IEnum {
    MONDAY(0,"周一"),
    TUESDAY(1,"周二"),
    WEDNESDAY(2,"周三"),
    THURSDAY(3,"周四"),
    FRIDAY(4,"周五"),
    SATURDAY(5,"周六"),
    SUNDAY(6,"周日");

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

    DayType(int value, String desc){
        this.value = value;
        this.desc = desc;
    }
    public static String typeName() {
        return "日期类型";
    }
    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

    public static  DayType valueOf(Integer value){
        if(value == MONDAY.value){
            return  MONDAY;
        }
        else if(TUESDAY.value == value){
            return  TUESDAY;
        }
        else if(WEDNESDAY.value == value){
            return  WEDNESDAY;
        } if(THURSDAY.value == value){
            return  THURSDAY;
        } if(FRIDAY.value == value){
            return  FRIDAY;
        } if(SATURDAY.value == value){
            return  SATURDAY;
        }
        return SUNDAY;
    }
}
