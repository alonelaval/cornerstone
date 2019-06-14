package com.alonelaval.common.exception;

/**
 * @author huawei
 * @create 2018-07-30
 **/
public class UserNotLoginException extends ServiceException {
    private final static  int USER_NOT_FOUND_CODE= 7;
    public UserNotLoginException(String errorString) {
        super(USER_NOT_FOUND_CODE,errorString);
    }


}
