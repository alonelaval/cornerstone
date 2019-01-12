package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author
 * @create 2018-07-21
 **/
public enum JobType implements IEnum {

    FULL_TIME(0,"全职"),
    PART_TIME(1,"兼职"),
    ASSIGN_TIME(2,"指定时间"),
    HOURLY(3,"小时工");
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

    JobType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }
    public static String typeName() {
        return "工作类型";
    }

    public static JobType valueOf(Integer value){
        if(value == JobType.FULL_TIME.value){
            return  JobType.FULL_TIME;
        }
        else if(value == JobType.PART_TIME.value){
            return  JobType.PART_TIME;
        }else if(value == JobType.ASSIGN_TIME.value){
            return  JobType.ASSIGN_TIME;
        }else {
            return  JobType.HOURLY;
        }
    }
}
