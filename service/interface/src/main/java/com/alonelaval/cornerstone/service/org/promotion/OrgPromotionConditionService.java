package com.alonelaval.cornerstone.service.org.promotion;

import com.alonelaval.cornerstone.entity.biz.OrgPromotionCondition;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgPromotionConditionService  extends IBaseService<OrgPromotionCondition,Integer> {
    default void addOrgPromotionCondition(OrgPromotionCondition orgPromotionCondition) throws Exception{
   }

}