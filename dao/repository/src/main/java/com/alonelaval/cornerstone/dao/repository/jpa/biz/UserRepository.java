package com.alonelaval.cornerstone.dao.repository.jpa.biz;

import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.entity.biz.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author huawei
 * @create 2018-07-07
 **/
@Repository
public interface UserRepository extends BaseRepository<User,Integer> {
    User findByLoginName(String loginName);
    User findByPhone(String phone);
    User findByEmail(String email);

    @Modifying
    @Query(value="update tb_user set state = :state where user_id in :userIds ",nativeQuery=true)
    void updateUsersState(@Param("state")Integer state,@Param("userIds")Integer ... userIds);
}
