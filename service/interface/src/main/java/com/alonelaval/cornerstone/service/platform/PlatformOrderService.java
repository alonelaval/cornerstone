package com.alonelaval.cornerstone.service.platform;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.PlatformOrder;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface PlatformOrderService  extends IBaseService<PlatformOrder,Integer> {
    default PlatformOrder addPlatformOrder(PlatformOrder platformOrder) throws Exception{
         return this.add(platformOrder);
    }

    void invoicePlatformOrder(List<Integer> orderIds,Integer  invoiceId,Integer addresseeId)throws  Exception;
}