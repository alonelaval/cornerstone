package com.alonelaval.cornerstone.servce.impl.org.promotion;

import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgPromotionConditionDao;
import com.alonelaval.cornerstone.entity.biz.OrgPromotionCondition;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.promotion.OrgPromotionConditionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgPromotionConditionService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgPromotionConditionServiceImpl extends AbstractBaseService<OrgPromotionCondition,Integer>  implements OrgPromotionConditionService {
    @Autowired
    OrgPromotionConditionDao orgPromotionConditionDao;
    

    @Override
    protected IBaseDao<OrgPromotionCondition,Integer> getBaseDao() {
        return orgPromotionConditionDao;
    }
}
