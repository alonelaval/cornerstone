package com.alonelaval.cornerstone.servce.impl.message;

import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.SysMessageRuleTypeDao;
import com.alonelaval.cornerstone.entity.biz.SysMessageRuleType;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.message.SysMessageRuleTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("sysMessageRuleTypeService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
@Deprecated
public class SysMessageRuleTypeServiceImpl extends AbstractBaseService<SysMessageRuleType,Integer> implements SysMessageRuleTypeService {
    @Autowired
    SysMessageRuleTypeDao sysMessageRuleTypeDao;
    

    @Override
    protected IBaseDao<SysMessageRuleType,Integer> getBaseDao() {
        return sysMessageRuleTypeDao;
    }
}
