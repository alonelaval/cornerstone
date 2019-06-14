package com.alonelaval.common.exception;

/**
 * @author huawei
 * @create 2018-07-10
 **/
public class DaoException extends  BaseException {
    public DaoException(String errorString) {
        super(errorString);
    }
    public DaoException(int errorCode, String errorString)
    {
        super(errorCode,errorString);
    }
    public DaoException( String errorString, Throwable cause)
    {
        super(errorString, cause);

    }
    public DaoException(int errorCode,String errorString, Throwable cause)
    {
        super(errorCode,errorString, cause);
    }
}
