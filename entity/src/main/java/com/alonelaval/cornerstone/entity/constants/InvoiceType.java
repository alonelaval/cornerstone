package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-07-29
 **/
public enum  InvoiceType implements IEnum {
    ORDINART_INVOICE(0,"普遍发票"),
    APPRECIATION_INVOICE(1,"增值税发票"),
    ELECTRON_INVOICE(2,"电子发票");

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

    InvoiceType(int value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public static String typeName() {
        return "发票类型";
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }



    public static InvoiceType valueOf(Integer value) {

        if(value == ORDINART_INVOICE.value){
            return ORDINART_INVOICE;
        }
        else if(value == APPRECIATION_INVOICE.value){
            return APPRECIATION_INVOICE;
        }
        else {
            return  ELECTRON_INVOICE;
        }
    }
}
