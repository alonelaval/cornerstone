package com.alonelaval.cornerstone.dao.impl.org.promotion;

import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgPromotionRuleDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgPromotionRuleRepository;
import com.alonelaval.cornerstone.entity.biz.OrgPromotionRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgPromotionRuleDao")
public class OrgPromotionRuleDaoImpl  extends AbstractBaseDao<OrgPromotionRule,Integer> implements OrgPromotionRuleDao {

    @Autowired
    OrgPromotionRuleRepository orgPromotionRuleRepository;

    @Override
    protected BaseRepository<OrgPromotionRule, Integer> getBaseRepository() {
        return orgPromotionRuleRepository;
    }
}
