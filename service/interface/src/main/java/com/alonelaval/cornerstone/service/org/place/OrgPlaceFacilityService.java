package com.alonelaval.cornerstone.service.org.place;


import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.OrgPlace;
import com.alonelaval.cornerstone.entity.biz.OrgPlaceFacility;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgPlaceFacilityService  extends IBaseService<OrgPlaceFacility,Integer> {
    default OrgPlaceFacility addOrgPlaceFacility(OrgPlaceFacility orgPlaceFacility) throws Exception{
    	return this.add(orgPlaceFacility);
    }

    List<OrgPlaceFacility> addOrgPlaceFacility(OrgPlace orgPlace, List<Integer> facilityIds)throws Exception;
}