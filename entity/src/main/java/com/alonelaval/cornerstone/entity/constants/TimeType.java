package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-08-12
 **/
public enum TimeType implements IEnum {

    AM(0, "上午"),
    PM(1,"下午");


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

    TimeType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "时间类型";
    }

    public static TimeType valueOf(Integer value){
        if(value == AM.value){
            return  AM;
        }
        else{
            return  PM;
        }
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

}
