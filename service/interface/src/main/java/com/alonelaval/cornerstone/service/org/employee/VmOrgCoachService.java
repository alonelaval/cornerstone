package com.alonelaval.cornerstone.service.org.employee;


import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.VmOrgCoach;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface VmOrgCoachService  extends IBaseService<VmOrgCoach,Integer> {
    default VmOrgCoach addVmOrgCoach(VmOrgCoach vmOrgCoach) throws Exception{
    	return this.add(vmOrgCoach);
    }

}