package com.alonelaval.common.exception;

import com.alonelaval.common.entity.IEnum;

/**
 * @author huawei
 * @create 2018-08-22
 **/
public abstract  class ExceptionUtil {
    public static  void throwServiceException(int code,String desc)throws  Exception{
        throw  new ServiceException(code,desc);
    }
    public static  void throwServiceException(IEnum iEnum)throws  Exception{
        throw  new ServiceException(iEnum.value(),iEnum.desc());
    }
}
