package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-09-28
 **/
public enum EvaluateType  implements IEnum {
    ORDER(0,"订单"),
    COURSE(1,"课程"),
    COACH(2,"教练"),
    ORG(3,"机构");

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

    EvaluateType(int value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public static String typeName() {
        return "评价的对象类型";
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

    public static EvaluateType valueOf(Integer value) {

        if(value == ORDER.value){
            return ORDER;
        }
        else if(value == COURSE.value){
            return COURSE;
        }
        else if(value == COACH.value){
            return COACH;
        }
        else {
            return  ORG;
        }
    }
}
