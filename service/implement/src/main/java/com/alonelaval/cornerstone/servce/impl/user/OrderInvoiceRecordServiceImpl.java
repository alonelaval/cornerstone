package com.alonelaval.cornerstone.servce.impl.user;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.OrderInvoiceRecordDao;
import com.alonelaval.cornerstone.entity.biz.OrderInvoiceRecord;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.user.OrderInvoiceRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orderInvoiceRecordService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrderInvoiceRecordServiceImpl extends AbstractBaseService<OrderInvoiceRecord,Integer> implements OrderInvoiceRecordService {
    @Autowired
    OrderInvoiceRecordDao orderInvoiceRecordDao;
    

    @Override
    protected IBaseDao<OrderInvoiceRecord,Integer> getBaseDao() {
        return orderInvoiceRecordDao;
    }
}
