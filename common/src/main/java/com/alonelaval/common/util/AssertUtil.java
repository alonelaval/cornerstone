package com.alonelaval.common.util;

import com.alonelaval.common.entity.IEnum;
import com.alonelaval.common.exception.ServiceException;

/**
 * @author huawei
 * @create 2018-08-01
 **/
public abstract class AssertUtil {

    public static void isTrue(boolean expression, ServiceException ex) throws ServiceException {
        if (expression) {
            throw ex;
        }
    }

    public static void isTrue(boolean expression, IEnum iEnum) throws ServiceException {
        if (expression) {
            throw new ServiceException(iEnum.value(),iEnum.desc());
        }
    }
}
