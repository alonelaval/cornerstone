package com.alonelaval.cornerstone.dao.repository.jpa.biz;

import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.entity.biz.UserAddressee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-111
 * create by python 
 **/
@Repository
public interface UserAddresseeRepository extends BaseRepository<UserAddressee,Integer> {
    List<UserAddressee> findAllByUserId(Integer userId);
}
