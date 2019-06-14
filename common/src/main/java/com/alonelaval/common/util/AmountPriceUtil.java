package com.alonelaval.common.util;

/**
 * @author huawei
 * @create 2018-08-12
 **/
public class AmountPriceUtil {
    public final static Integer COEFFICIENT = 100;

    public static  final Integer input(Integer price){
        if(price == null){
            return  price;
        }
        return  COEFFICIENT * price;
    }
    public  static final Double output(Integer price){
        if(price == null){
            return  null;
        }
        return Double.valueOf(price) / COEFFICIENT;
    }
}
