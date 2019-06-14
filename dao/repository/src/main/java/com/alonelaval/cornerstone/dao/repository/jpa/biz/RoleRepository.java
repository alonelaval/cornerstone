package com.alonelaval.cornerstone.dao.repository.jpa.biz;

import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.entity.biz.Role;
import com.alonelaval.cornerstone.entity.constants.RoleCreateType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-111
 * create by python 
 **/
@Repository
public interface RoleRepository extends BaseRepository<Role,Integer> {
    List<Role> findAllByRoleIdIn(List<Integer> roleIds);
    List<Role> findAllByOrgId(Integer orgId);
    List<Role> findAllByOrgIdAndFromRoleIdIn(Integer orgId,List<Integer> fromRoleId);

    List<Role> findAllByOrgIdAndFromRoleIdNotNull(Integer orgId);

    List<Role> findByOrgIdAndCreateType(Integer orgId, RoleCreateType createType);
}
