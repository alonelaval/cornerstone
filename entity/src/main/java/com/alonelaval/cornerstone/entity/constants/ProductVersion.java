package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-07-23
 **/
public enum  ProductVersion implements IEnum {

    TEST(0,"测试版");
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

    ProductVersion(int value, String desc){
        this.value = value;
        this.desc = desc;
    }

    public  static String typeName() {
        return "系统版本";
    }

    public static  ProductVersion valueOf(Integer value){
        if(value == TEST.value){
            return  TEST;
        }
        else{
            return  TEST;
        }
    }
    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

}
