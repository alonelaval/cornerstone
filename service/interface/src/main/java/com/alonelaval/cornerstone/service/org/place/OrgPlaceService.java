package com.alonelaval.cornerstone.service.org.place;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.OrgPlace;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.Optional;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgPlaceService  extends IBaseService<OrgPlace,Integer> {
    default OrgPlace addOrgPlace(OrgPlace orgPlace) throws Exception{
        return  add(orgPlace);
    }

    Optional<OrgPlace> findOneByPlaceNameAndOrgId(String placeName, Integer orgId)throws  Exception;

}