package com.alonelaval.cornerstone.service.message;

import com.alonelaval.cornerstone.entity.biz.SysMessageRuleType;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Deprecated
public interface SysMessageRuleTypeService  extends IBaseService<SysMessageRuleType,Integer> {
    default SysMessageRuleType addSysMessageRuleType(SysMessageRuleType sysMessageRuleType) throws Exception{
        return  this.add(sysMessageRuleType);
   }

}