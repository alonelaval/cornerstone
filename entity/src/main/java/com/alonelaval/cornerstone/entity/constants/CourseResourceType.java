package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-08-12
 **/
public enum CourseResourceType implements IEnum {

    PICTURE(0, "图片");


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

    CourseResourceType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "课程资源类型";
    }

    public static CourseResourceType valueOf(Integer value){
        if(value == PICTURE.value){
            return  PICTURE;
        }
        return  null;
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

}
