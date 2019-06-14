package com.alonelaval.cornerstone.servce.impl.org.order;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgOrderPromotionDao;
import com.alonelaval.cornerstone.entity.biz.OrgOrderPromotion;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.order.OrgOrderPromotionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgOrderPromotionService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgOrderPromotionServiceImpl extends AbstractBaseService<OrgOrderPromotion,Integer> implements OrgOrderPromotionService {
    @Autowired
    OrgOrderPromotionDao orgOrderPromotionDao;
    

    @Override
    protected IBaseDao<OrgOrderPromotion,Integer> getBaseDao() {
        return orgOrderPromotionDao;
    }
}
