package com.alonelaval.cornerstone.dao.repository.jpa.biz;

import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.entity.biz.OrgResource;
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
public interface OrgResourceRepository extends BaseRepository<OrgResource,Integer> {

    @Modifying
    @Query(value="update tb_org_resource set state = :state where org_id = :orgId ",nativeQuery=true)
    void updateStateByOrgId(@Param("orgId")Integer orgId,@Param("state") Integer state);
}
