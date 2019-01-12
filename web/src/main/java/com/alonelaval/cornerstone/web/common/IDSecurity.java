package com.alonelaval.cornerstone.web.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author huawei
 * @create 2018-07-22
 * 对ID进行解密
 * @deprecated 直接使用converter
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
public @interface IDSecurity {
}