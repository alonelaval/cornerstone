package com.alonelaval.cornerstone.servce.impl.org.promotion;

import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgPromotionRuleDao;
import com.alonelaval.cornerstone.entity.biz.OrgPromotionRule;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.promotion.OrgPromotionRuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgPromotionRuleService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgPromotionRuleServiceImpl extends AbstractBaseService<OrgPromotionRule,Integer>  implements OrgPromotionRuleService {
    @Autowired
    OrgPromotionRuleDao orgPromotionRuleDao;
    

    @Override
    protected IBaseDao<OrgPromotionRule,Integer> getBaseDao() {
        return orgPromotionRuleDao;
    }
}
