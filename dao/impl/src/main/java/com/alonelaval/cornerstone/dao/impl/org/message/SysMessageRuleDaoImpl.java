package com.alonelaval.cornerstone.dao.impl.org.message;

import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.SysMessageRuleDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.SysMessageRuleRepository;
import com.alonelaval.cornerstone.entity.biz.SysMessageRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="sysMessageRuleDao")
public class SysMessageRuleDaoImpl  extends AbstractBaseDao<SysMessageRule,Integer> implements SysMessageRuleDao {

    @Autowired
    SysMessageRuleRepository sysMessageRuleRepository;

    @Override
    protected BaseRepository<SysMessageRule, Integer> getBaseRepository() {
        return sysMessageRuleRepository;
    }
}
