package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-08-12
 **/
public enum AllowUserSettingCourseTimeType implements IEnum {
    /**
     * 租凭
     */
    TRUE(0, "是"),
    /***
     * 自拥
     */
    FALSE(1, "否");


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

    AllowUserSettingCourseTimeType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "是否允许用户自定义上课时间";
    }

    public static AllowUserSettingCourseTimeType valueOf(Integer value){
        if(value == TRUE.value){
            return  TRUE;
        }
        else{
            return  FALSE;
        }
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

}
