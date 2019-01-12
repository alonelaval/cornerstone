package com.alonelaval.cornerstone.dao.repository.jpa.biz;

import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.entity.biz.UserRole;
import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-111
 * create by python 
 **/
@Repository
public interface UserRoleRepository extends BaseRepository<UserRole,Integer> {
    List<UserRole> findAllByUserId(Integer userId);
    List<UserRole> findAllByUserIdAndOrgIdIsNull(Integer userId);
    List<UserRole> findAllByUserIdAndOrgId(Integer userId,Integer orgId);
    List<UserRole> findAllByUserIdAndOwnType(Integer userId,RoleOwnType ownType);
    List<UserRole> findAllByUserIdAndOwnTypeAndOrgId(Integer userId, RoleOwnType ownType, Integer orgId);
    List<UserRole> findAllByUserIdAndOwnTypeAndOrgIdAndRoleIdIn(Integer userId, RoleOwnType ownType, Integer orgId,List<Integer> roleIds);

}

