package com.alonelaval.cornerstone.dao.impl.user;

import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.OrderInvoiceRecordDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrderInvoiceRecordRepository;
import com.alonelaval.cornerstone.entity.biz.OrderInvoiceRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="OrderInvoiceRecordDao")
public class OrderInvoiceRecordDaoImpl  extends AbstractBaseDao<OrderInvoiceRecord,Integer> implements OrderInvoiceRecordDao {

    @Autowired
    OrderInvoiceRecordRepository orderInvoiceRecordRepository;

    @Override
    protected BaseRepository<OrderInvoiceRecord, Integer> getBaseRepository() {
        return orderInvoiceRecordRepository;
    }
}
