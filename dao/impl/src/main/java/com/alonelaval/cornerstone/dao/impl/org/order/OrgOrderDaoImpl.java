package com.alonelaval.cornerstone.dao.impl.org.order;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.org.order.OrgOrderDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgOrderRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.order.OrgOrderDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgOrderRepository;
import com.alonelaval.cornerstone.entity.biz.OrgOrder;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.IsInvoiced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgOrgDao")
public class OrgOrderDaoImpl extends AbstractBaseDao<OrgOrder,Integer> implements OrgOrderDao {

    @Autowired
    OrgOrderRepository orgOrderRepository;

    @Override
    protected BaseRepository getBaseRepository() {
        return orgOrderRepository;
    }

    @Override
    public void updateOrderInvoiceRecordId(List<Integer> orderIds, Integer oirId,IsInvoiced isInvoiced) throws DaoException {
        try {
            orgOrderRepository.updateOrderInvoiceRecordId(orderIds,oirId, isInvoiced.value());
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }
}
