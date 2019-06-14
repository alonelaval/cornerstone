package com.alonelaval.cornerstone.service.message;

import com.alonelaval.cornerstone.entity.biz.SysMessageRule;
import com.alonelaval.cornerstone.entity.constants.AuditState;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface SysMessageRuleService  extends IBaseService<SysMessageRule,Integer> {
    default SysMessageRule addSysMessageRule(SysMessageRule sysMessageRule) throws Exception{
        return  this.add(sysMessageRule);
    }

    /**
     * 对消息模版进行审核
     * @param id
     * @param auditState
     * @return
     * @throws Exception
     */
    SysMessageRule auditRule(Integer id, AuditState auditState)throws Exception;
}