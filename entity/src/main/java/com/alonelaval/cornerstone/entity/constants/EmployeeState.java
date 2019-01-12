package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-07-21
 **/
public enum  EmployeeState implements IEnum {
    ENABLED(0,"在职"),
    VACATION(1,"休假"),
    DISCHARGE(2,"开除"),
    AUDIT(3,"审核中"),
    AUDIT_NO_PASS(4,"审核不通过"),
    DIMENSION(5,"离职");

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

    EmployeeState(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }


    public static String typeName() {
        return "员工状态";
    }

    public static  boolean isNormal(Integer value){
        if(EmployeeState.ENABLED.value() ==value || EmployeeState.VACATION.value == value) {
            return  true;
        }
        return  false;
    }

    public static EmployeeState valueOf(Integer value) {

        if(EmployeeState.ENABLED.value() ==value) {
            return ENABLED;
        }
        else
        if(EmployeeState.DISCHARGE.value() ==value) {
            return DISCHARGE;
        }
        else
        if(EmployeeState.VACATION.value() ==value) {
            return VACATION;
        }
        else
        if(EmployeeState.AUDIT.value() ==value) {
            return AUDIT;
        }
        else
        if(EmployeeState.AUDIT_NO_PASS.value() ==value) {
            return AUDIT_NO_PASS;
        }
        else{
            return DIMENSION;
        }

    }
}
