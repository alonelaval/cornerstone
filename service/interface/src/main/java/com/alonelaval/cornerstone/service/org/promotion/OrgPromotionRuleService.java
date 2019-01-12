package com.alonelaval.cornerstone.service.org.promotion;

import com.alonelaval.cornerstone.entity.biz.OrgPromotionRule;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgPromotionRuleService  extends IBaseService<OrgPromotionRule,Integer> {
    default void addOrgPromotionRule(OrgPromotionRule orgPromotionRule) throws Exception{
   }

}