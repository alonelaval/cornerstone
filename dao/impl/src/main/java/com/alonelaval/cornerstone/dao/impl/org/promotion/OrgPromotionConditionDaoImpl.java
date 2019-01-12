package com.alonelaval.cornerstone.dao.impl.org.promotion;

import com.alonelaval.cornerstone.dao.inter.org.OrgPromotionConditionDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgPromotionConditionRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgPromotionConditionDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgPromotionConditionRepository;
import com.alonelaval.cornerstone.entity.biz.OrgPromotionCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgPromotionConditionDao")
public class OrgPromotionConditionDaoImpl  extends AbstractBaseDao<OrgPromotionCondition,Integer> implements OrgPromotionConditionDao {

    @Autowired
    OrgPromotionConditionRepository orgPromotionConditionRepository;

    @Override
    protected BaseRepository<OrgPromotionCondition, Integer> getBaseRepository() {
        return orgPromotionConditionRepository;
    }
}
