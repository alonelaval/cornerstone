package com.alonelaval.common.exception;

/**
 * @author huawei
 * @create 2018-07-10
 **/
public class BaseException extends  Exception {
    private Integer errorCode ;

    public BaseException()
    {
        super();
    }

    public BaseException(String errorString)
    {
        super(errorString);
    }

    public BaseException(int errorCode, String errorString)
    {
        super(errorString);
        this.errorCode = errorCode;

    }
    public BaseException( String errorString, Throwable cause)
    {
        super(errorString, cause);

    }


    public BaseException(int errorCode, String errorString, Throwable cause)
    {
        super(errorString, cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode()
    {
        return this.errorCode;
    }

    public String getErrorString()
    {
        return this.getMessage();
    }
}
