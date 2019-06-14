package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * 是否已开发票
 * @author huawei
 * @create 2018-07-09
 **/
public enum  IsInvoiced implements IEnum {
    NOT_INVOICE(0,"未开票"),
    APPLY_INVOICE(1,"申请开票"),
    INVOICED(3,"已开票");

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

    IsInvoiced(int value,String desc){
        this.value = value;
        this.desc = desc;
    }
    public  static String typeName() {
        return "是否开发票";
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }



    public static IsInvoiced valueOf(Integer value) {

        if(value == INVOICED.value){
            return INVOICED;
        }else
        if(APPLY_INVOICE.value == value)
        {
            return APPLY_INVOICE;
        }
        else{
            return APPLY_INVOICE;
        }

    }

}
