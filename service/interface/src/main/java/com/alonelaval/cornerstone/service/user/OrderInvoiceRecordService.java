package com.alonelaval.cornerstone.service.user;

import com.alonelaval.cornerstone.entity.biz.OrderInvoiceRecord;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrderInvoiceRecordService  extends IBaseService<OrderInvoiceRecord,Integer> {
    default OrderInvoiceRecord addOrderInvoiceRecord(OrderInvoiceRecord orderInvoiceRecord) throws Exception{
    	return this.add(orderInvoiceRecord);
   }

}