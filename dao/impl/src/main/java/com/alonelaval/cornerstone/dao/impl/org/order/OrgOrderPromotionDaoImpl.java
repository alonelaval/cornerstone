package com.alonelaval.cornerstone.dao.impl.org.order;

import com.alonelaval.cornerstone.dao.inter.org.OrgOrderPromotionDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgOrderPromotionRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgOrderPromotionDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgOrderPromotionRepository;
import com.alonelaval.cornerstone.entity.biz.OrgOrderPromotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgOrderPromotionDao")
public class OrgOrderPromotionDaoImpl  extends AbstractBaseDao<OrgOrderPromotion,Integer> implements OrgOrderPromotionDao {

    @Autowired
    OrgOrderPromotionRepository orgOrderPromotionRepository;

    @Override
    protected BaseRepository<OrgOrderPromotion, Integer> getBaseRepository() {
        return orgOrderPromotionRepository;
    }
}
