package com.alonelaval.cornerstone.service.org.log;

import com.alonelaval.cornerstone.entity.biz.OperationLog;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OperationLogService extends IBaseService<OperationLog,Integer> {
    default void addOperationLog(OperationLog orgOperationLog) throws Exception{
   }

}