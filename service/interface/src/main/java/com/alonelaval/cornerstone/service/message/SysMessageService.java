package com.alonelaval.cornerstone.service.message;

import com.alonelaval.cornerstone.entity.biz.SysMessage;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface SysMessageService  extends IBaseService<SysMessage,Integer> {
    default SysMessage addSysMessage(SysMessage sysMessage) throws Exception{
        return this.add(sysMessage);
   }

}