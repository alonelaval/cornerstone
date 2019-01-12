package com.alonelaval.common.entity;

/**
 * @author
 * @create 2018-07-07
 *
 **/
public interface IEnum {

    /***
     *
     * @return
     */
     int value();

     IEnum value(int value);

//    /**
//     * 枚举中的方法
//     * @return
//     */
//    int ordinal();

    /***
     * 中文描述
     * @return
     */
    String desc();

//    /***
//     * 类型名称
//     * @return
//     */
//    String typeName();


}
