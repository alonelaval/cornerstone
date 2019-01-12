package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-08-05
 **/
public enum  OrderState  implements IEnum {
    NOT_PAID(0,"未支付"),
    PAID(1,"已支付"),
    PAYMENT_FAILURE(2,"支付失败"),
    UNDERWAY(3,"进行中"),
    FINISH(4,"完成"),
    REFUND(5,"申请退款"),
    FINISH_REFUND(6,"退款完成");

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

    OrderState(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public static String typeName() {
        return "订单状态";
    }

    public static OrderState valueOf(Integer value) {

        if(NOT_PAID.value() ==value) {
            return NOT_PAID;
        }
        else
        if(PAID.value() ==value) {
            return PAID;
        }
        else
        if(PAYMENT_FAILURE.value() ==value) {
            return PAYMENT_FAILURE;
        }
        else
        if(UNDERWAY.value() ==value) {
            return UNDERWAY;
        }
        if(REFUND.value() ==value) {
            return REFUND;
        }
        if(FINISH_REFUND.value() ==value) {
            return FINISH_REFUND;
        }
        else{
            return FINISH;
        }
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }
}
