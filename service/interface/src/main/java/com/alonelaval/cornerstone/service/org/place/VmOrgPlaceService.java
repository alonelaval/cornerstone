package com.alonelaval.cornerstone.service.org.place;


import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.VmOrgPlace;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface VmOrgPlaceService  extends IBaseService<VmOrgPlace,Integer> {
    default VmOrgPlace addVmOrgPlace(VmOrgPlace vmOrgPlace) throws Exception{
    	return this.add(vmOrgPlace);
    }

}