package com.alonelaval.cornerstone.service.org.promotion;

import com.alonelaval.cornerstone.entity.biz.OrgGift;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgGiftService  extends IBaseService<OrgGift,Integer> {
    default void addOrgGift(OrgGift orgGift) throws Exception{
   }

}