package com.alonelaval.cornerstone.dao.repository.jpa.biz;

import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.entity.biz.PlatformOrder;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-111
 * create by python 
 **/
@Repository
public interface PlatformOrderRepository extends BaseRepository<PlatformOrder,Integer> {
    List<PlatformOrder> findAllByOrderIdIn(List<Integer> ids);

    @Modifying
    @Query(value = "update tb_platform_order set oir_id = :oirId,is_invoiced=:isInvoice where order_id in :ids",nativeQuery = true)
    void updatePlatformOrderInvoiceRecordId(@Param("ids") List<Integer> ids, @Param("oirId") Integer oirId
        ,@Param("isInvoice") int isInvoice);
}
