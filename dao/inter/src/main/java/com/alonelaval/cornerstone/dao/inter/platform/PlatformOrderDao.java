package com.alonelaval.cornerstone.dao.inter.platform;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.PlatformOrder;
import com.alonelaval.cornerstone.entity.constants.IsInvoiced;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface PlatformOrderDao  extends IBaseDao<PlatformOrder,Integer> {
//  List<PlatformOrder> findAllByIds(List<Integer> ids)throws DaoException;

  void updatePlatformOrderInvoiceRecordId(List<Integer> ids, Integer oirId, IsInvoiced isInvoice)throws  DaoException;
}
