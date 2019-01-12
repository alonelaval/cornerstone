package com.alonelaval.cornerstone.service.platform;


import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.Facility;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.Optional;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface FacilityService  extends IBaseService<Facility,Integer> {
    default Facility addFacility(Facility facility) throws Exception{
    	return this.add(facility);
    }
    Optional<Facility> findOneByFacilityName(String facilityName)throws Exception;
}