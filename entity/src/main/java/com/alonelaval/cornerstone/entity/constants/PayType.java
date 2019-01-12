package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-08-05
 **/
public enum  PayType implements IEnum {

    ALI_PAY(0,"支付宝"),
    WECHAT_PAY(1,"微信"),
    QQ_PAY(2,"QQ"),
    BANK_PAY(3,"银行"),
    OTHER(4,"其他");

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

    PayType(int value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public static String typeName() {
        return "支付方式";
    }


    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

    public static PayType valueOf(Integer value) {
        if (value == ALI_PAY.value) {
            return ALI_PAY;
        }else if(value == WECHAT_PAY.value) {
            return WECHAT_PAY;
        }
        else if(value == QQ_PAY.value) {
            return QQ_PAY;
        }else if(value == BANK_PAY.value) {
            return BANK_PAY;
        }
        else {
            return OTHER;
        }
    }
}
