package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-07-21
 **/
public enum  EduBackground implements IEnum {

    MIDDLE_SCHOOL(0, "初中"),
    HIGH_SCHOOL(1, "高中"),
    COOLEGE(2, "大专"),
    UNDERGRADUATE(3, "本科"),
    MASTER(4, "硕士"),
    DOCTOR(5, "博士"),
    PROFESSOR(6,"教授");


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

    EduBackground(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }


    public static String typeName() {
        return "教育背景";
    }

    public static EduBackground valueOf(Integer value) {

            if(EduBackground.MIDDLE_SCHOOL.value() == value) {
                return MIDDLE_SCHOOL;
            }else
            if(EduBackground.HIGH_SCHOOL.value() == value) {
                return HIGH_SCHOOL;
            }else

            if(EduBackground.COOLEGE.value() ==value ) {
                return COOLEGE;
            }else
            if(EduBackground.UNDERGRADUATE.value() ==value) {
                return MIDDLE_SCHOOL;
            }
            else
            if(EduBackground.MASTER.value() ==value) {
                return MASTER;
            }
            else{
                return DOCTOR;
            }

    }

}