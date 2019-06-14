package com.alonelaval.cornerstone.dao.repository.jpa.biz;

import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.entity.biz.OrgPermission;
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
public interface OrgPermissionRepository extends BaseRepository<OrgPermission,Integer> {
    List<OrgPermission> findAllByOpIdIn(List<Integer> ids);
    @Modifying
    @Query(value = " update tb_org_permission set state = :state where org_id = :orgId and permission_id in :ids",nativeQuery = true)
    void updateStateByOrgIdAndPermissionIds(@Param("ids") List<Integer> ids,@Param("orgId") Integer orgId, @Param("state") Integer state)throws  Exception;
}
