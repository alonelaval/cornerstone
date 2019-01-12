package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-08-13
 **/
public enum  UserRelationType implements IEnum {
    FATHER(0, "父亲"),
    MOTHER(1,"母亲"),
    GRANDFATHER(2,"爷爷"),
    GRANDMOTHER(3,"奶奶");
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

    UserRelationType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static String typeName() {
        return "用户关系";
    }

    public static UserRelationType valueOf(Integer value){
        if(value == FATHER.value){
            return  FATHER;
        }
        else if(value == MOTHER.value)
        {
            return MOTHER;
        }
        else if(value == GRANDFATHER.value)
        {
            return GRANDFATHER;
        }
        else{
            return  GRANDMOTHER;
        }
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }
}
