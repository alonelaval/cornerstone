package com.alonelaval.cornerstone.service.org.order;

import com.alonelaval.cornerstone.entity.biz.OrgOrder;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgOrderService  extends IBaseService<OrgOrder,Integer> {
    default OrgOrder addOrgOrder(OrgOrder orgOrder) throws Exception{
        return  this.add(orgOrder);
    }

    /***
     * 用户申请开发票
     * @param orderIds
     * @param invoiceId
     * @param addresseeId
     * @throws Exception
     */
    void invoiceOrder(List<Integer> orderIds, Integer invoiceId, Integer addresseeId)throws Exception;
}