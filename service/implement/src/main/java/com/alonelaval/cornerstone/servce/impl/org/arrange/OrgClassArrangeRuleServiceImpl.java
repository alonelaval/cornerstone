package com.alonelaval.cornerstone.servce.impl.org.arrange;

import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgClassArrangeRuleDao;
import com.alonelaval.cornerstone.entity.biz.OrgClassArrangeRule;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.arrange.OrgClassArrangeRuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgClassArrangeRuleService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgClassArrangeRuleServiceImpl extends AbstractBaseService<OrgClassArrangeRule,Integer> implements OrgClassArrangeRuleService {
    @Autowired
    OrgClassArrangeRuleDao orgArrangeRuleDao;
    

    @Override
    protected IBaseDao<OrgClassArrangeRule,Integer> getBaseDao() {
        return orgArrangeRuleDao;
    }
}
