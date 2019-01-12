package com.alonelaval.cornerstone.service.org.appointment;

import com.alonelaval.cornerstone.entity.biz.OrgUserAppointment;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgUserAppointmentService  extends IBaseService<OrgUserAppointment,Integer> {
    default void addOrgUserAppointment(OrgUserAppointment orgUserAppointment) throws Exception{
   }

}