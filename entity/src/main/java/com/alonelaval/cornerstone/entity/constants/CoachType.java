package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author
 * @create 2018-09-01
 **/
public enum CoachType implements IEnum {

    CHIEF_COACH(0,"主教练"),
    ASSISTANT_COACH(1,"助理教练");


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

    CoachType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "教练类型";
    }

    @Override
    public CoachType value(int value) {
        return valueOf(value);
    }

    public static CoachType valueOf(Integer value) {
        if (value == CHIEF_COACH.value) {
            return CHIEF_COACH;
        }
        return ASSISTANT_COACH;

    }
}
