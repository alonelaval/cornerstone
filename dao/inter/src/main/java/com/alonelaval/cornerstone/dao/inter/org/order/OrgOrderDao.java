package com.alonelaval.cornerstone.dao.inter.org.order;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.OrgOrder;
import com.alonelaval.cornerstone.entity.constants.IsInvoiced;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-09
 **/
public interface OrgOrderDao  extends IBaseDao<OrgOrder,Integer> {
    void updateOrderInvoiceRecordId(List<Integer> orderIds, Integer oirId, IsInvoiced isInvoiced) throws DaoException;
}
