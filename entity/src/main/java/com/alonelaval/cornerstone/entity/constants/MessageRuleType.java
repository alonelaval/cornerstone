package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-09-07
 **/
public enum  MessageRuleType implements IEnum {

    EXPIRE_WARNING(0,"到期预警"),
    PROMOTION_COURSE(1,"推送相关课程"),
    WAKE_USER(2,"唤醒沉默用户"),
    PROMOTION(3,"推送促销信息"),
    ARRANGE_COURSE(4,"预约课程已排课"),
    ATTEND_CLASS_REMINDER(5,"未签到上课提醒"),
    OTHER(6,"其他");


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

    MessageRuleType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

    public static String typeName() {
        return "消息规则类型";
    }

    public static MessageRuleType valueOf(Integer value){
        if(value == MessageRuleType.EXPIRE_WARNING.value){
            return  MessageRuleType.EXPIRE_WARNING;
        }
        else if(value == MessageRuleType.PROMOTION_COURSE.value){
            return  MessageRuleType.PROMOTION_COURSE;
        }else if(value == MessageRuleType.WAKE_USER.value){
            return  MessageRuleType.WAKE_USER;
        }else if(value == MessageRuleType.PROMOTION.value){
            return  MessageRuleType.PROMOTION;
        }
        else if(value == MessageRuleType.ARRANGE_COURSE.value){
            return  MessageRuleType.ARRANGE_COURSE;
        }
        else if(value == MessageRuleType.ATTEND_CLASS_REMINDER.value){
            return  MessageRuleType.ATTEND_CLASS_REMINDER;
        }
        else {
            return  MessageRuleType.OTHER;
        }
    }
}
