package com.alonelaval.cornerstone.dao.repository.jpa.biz;

import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.entity.biz.UserAddresseeTag;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author huawei
 * @create 2018-07-111
 * create by python 
 **/
@Repository
public interface UserAddresseeTagRepository extends BaseRepository<UserAddresseeTag,Integer> {

    @Modifying
    @Query(value="update tb_user_addressee_tag set state = :state where addressee_id = :addresseeId ",nativeQuery=true)
    void deleteAllByAddresseeId(@Param("state") Integer state ,@Param("addresseeId") Integer addresseeId);

}
