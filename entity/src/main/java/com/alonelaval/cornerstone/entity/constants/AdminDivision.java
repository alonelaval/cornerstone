package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author
 * @create 2018-08-28
 **/
public enum AdminDivision implements IEnum {
    PROVINCE(0,"省"),
    CITY(1,"市"),
    REGION(2,"区"),
    COUNTY(3,"县"),
    TOWN(4,"乡镇"),
    MUNICIPALITY(5,"直辖市");



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

    AdminDivision(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "行政区划";
    }

    @Override
    public AdminDivision value(int value) {
        return valueOf(value);
    }

    public static AdminDivision valueOf(Integer value) {
        if (value == PROVINCE.value) {
            return PROVINCE;
        } else if (CITY.value == value) {
            return CITY;
        }else if (REGION.value == value) {
            return REGION;
        }else if (COUNTY.value == value) {
            return COUNTY;
        }else if (TOWN.value == value) {
            return TOWN;
        }
        return MUNICIPALITY;
    }
}
