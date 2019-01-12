package com.alonelaval.common.exception;

/**
 * @author huawei
 * @create 2018-07-10
 **/
public class ServiceException extends  BaseException {

    public ServiceException()
    {
        super();
    }

    public ServiceException(String errorString)
    {
        super(errorString);
    }

    public ServiceException(int errorCode, String errorString)
    {
        super(errorCode,errorString);

    }
    public ServiceException( String errorString, Throwable cause)
    {
        super(errorString, cause);

    }
    public ServiceException( Throwable cause)
    {
        super(null, cause);

    }

}
