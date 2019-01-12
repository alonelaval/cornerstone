package com.alonelaval.cornerstone.dao.impl.org.message;

import com.alonelaval.cornerstone.dao.inter.org.SysMessageRuleTypeDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.SysMessageRuleTypeRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.SysMessageRuleTypeDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.SysMessageRuleTypeRepository;
import com.alonelaval.cornerstone.entity.biz.SysMessageRuleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="sysMessageRuleTypeDao")
public class SysMessageRuleTypeDaoImpl  extends AbstractBaseDao<SysMessageRuleType,Integer> implements SysMessageRuleTypeDao {

    @Autowired
    SysMessageRuleTypeRepository sysMessageRuleTypeRepository;

    @Override
    protected BaseRepository<SysMessageRuleType, Integer> getBaseRepository() {
        return sysMessageRuleTypeRepository;
    }
}
