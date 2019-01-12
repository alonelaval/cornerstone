package com.alonelaval.cornerstone.dao.impl.platform;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.platform.PlatformOrderDao;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.PlatformOrderRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.platform.PlatformOrderDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.PlatformOrderRepository;
import com.alonelaval.cornerstone.entity.biz.PlatformOrder;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.IsInvoiced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="platformOrderDao")
public class PlatformOrderDaoImpl  extends AbstractBaseDao<PlatformOrder,Integer> implements PlatformOrderDao {

    @Autowired
    PlatformOrderRepository platformOrderRepository;

    @Override
    protected BaseRepository<PlatformOrder, Integer> getBaseRepository() {
        return platformOrderRepository;
    }

//    @Override
//    public List<PlatformOrder> findAllByIds(List<Integer> ids) throws DaoException {
//        try {
//            return platformOrderRepository.findAllByOrderIdIn(ids);
//        } catch (Exception e) {
//            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
//        }
//    }

    @Override
    public void updatePlatformOrderInvoiceRecordId(List<Integer> ids, Integer oirId,IsInvoiced isInvoice) throws DaoException {
        try {
            platformOrderRepository.updatePlatformOrderInvoiceRecordId(ids,oirId,isInvoice.value());
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }
}
