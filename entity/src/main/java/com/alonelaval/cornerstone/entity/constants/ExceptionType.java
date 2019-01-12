package com.alonelaval.cornerstone.entity.constants;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-07-21
 **/
public enum  ExceptionType implements IEnum {
    SUCCESS(0,"成功"),
    NOT_AUTH(1,"没有权限"),
    NO_DATA(2,"没有数据"),
    RESULT_REQUEST_EXPIRE(3,"请求已过期"),
    PARAM_ERROR(4,"请求的参数错误"),
    USER_NOT_FOUND(5,"用户未找到"),
    RESULT_USER_PASSWORD_NOT_MATCH(6,"用户密码不匹配"),
    RESULT_USER_NEED_LOGIN(7,"用户未登录"),
    ORG_NAME_EXIST_EXCEPTION(8,"机构名称已经存在"),
    USER_NAME_EXIST_EXCEPTION(9,"用户名称已经存在"),
    PHONE_EXIST_EXCEPTION(10,"手机号码已经存在"),
    PHONE_CODE_VERITY_EXCEPTION(11,"手机验证码错误或已过期"),
    DAO_EXCEPTION(12,"数据库异常"),
    ORG_NOT_FOUND(13,"机构未找到"),

    USER_DISABLED_EXCEPTION(14,"用户已经被禁用"),
    OP_NOT_ALLOWED(15,"操作不被允许"),
    NAME_EXIST_EXCEPTION(16,"名称已经存在"),
    UNKNOWN_ERROR(9999,"未知错误");



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

    ExceptionType(int value, String desc){
        this.value = value;
        this.desc = desc;
    }
    public static String typeName() {
        return "平台异常类型";
    }

    public static  ExceptionType valueOf(Integer value){
//        if(value == ORG_NAME_EXIST_EXCEPTION.value){
//            return  ORG_NAME_EXIST_EXCEPTION;
//        }
//        else{
//            return  ORG_NAME_EXIST_EXCEPTION;
//        }
        return  SUCCESS;
    }

    @Override
    public IEnum value(int value) {
        return valueOf(value);
    }

}
