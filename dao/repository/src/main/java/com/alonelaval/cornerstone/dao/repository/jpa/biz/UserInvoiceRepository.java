package com.alonelaval.cornerstone.dao.repository.jpa.biz;

import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.entity.biz.UserInvoice;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-111
 * create by python 
 **/
@Repository
public interface UserInvoiceRepository extends BaseRepository<UserInvoice,Integer> {
//    @Modifying
//    @Query(value="update tb_user_invoice set state = :state where invoice_id in :invoiceIds ",nativeQuery=true)
//    void updateState(@Param("state")Integer state, @Param("invoiceIds")Integer ... invoiceIds);

    List<UserInvoice> findAllByUserId(Integer userId);

}
