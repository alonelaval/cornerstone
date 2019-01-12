package com.alonelaval.cornerstone.dao.repository.jpa.biz;

import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.entity.biz.OrgOrder;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-07
 **/
@Repository
public interface OrgOrderRepository extends BaseRepository<OrgOrder,Integer> {

    @Modifying
    @Query(value = "update tb_org_order set oir_id = :oirId,is_invoiced = :isInvoiced where org_order_id in :ids ",nativeQuery = true)
    void updateOrderInvoiceRecordId(@Param("ids") List<Integer> orderIds, @Param("oirId") Integer oirId, @Param("isInvoiced")
            int isInvoiced);
}
