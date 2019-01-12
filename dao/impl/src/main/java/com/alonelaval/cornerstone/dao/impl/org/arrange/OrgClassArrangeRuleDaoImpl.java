package com.alonelaval.cornerstone.dao.impl.org.arrange;

import com.alonelaval.cornerstone.dao.inter.org.OrgClassArrangeRuleDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgClassArrangeRuleRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgClassArrangeRuleDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgClassArrangeRuleRepository;
import com.alonelaval.cornerstone.entity.biz.OrgClassArrangeRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgClassArrangeRuleDao")
public class OrgClassArrangeRuleDaoImpl extends AbstractBaseDao<OrgClassArrangeRule,Integer> implements OrgClassArrangeRuleDao {

    @Autowired
    OrgClassArrangeRuleRepository orgArrangeRuleRepository;

    @Override
    protected BaseRepository<OrgClassArrangeRule, Integer> getBaseRepository() {
        return orgArrangeRuleRepository;
    }
}
