package com.alonelaval.cornerstone.dao.repository.jpa.biz;

import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.entity.biz.OrgPlace;
import org.springframework.stereotype.Repository;

/**
 * @author huawei
 * @create 2018-07-111
 * create by python 
 **/
@Repository
public interface OrgPlaceRepository extends BaseRepository<OrgPlace,Integer> {
    OrgPlace findOneByPlaceNameAndOrgId(String placeName, Integer orgId);
}
