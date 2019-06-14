package com.alonelaval.cornerstone.service.org.order;

import com.alonelaval.cornerstone.entity.biz.OrgOrderPromotion;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgOrderPromotionService  extends IBaseService<OrgOrderPromotion,Integer> {
    default void addOrgOrderPromotion(OrgOrderPromotion orgOrderPromotion) throws Exception{
   }

}