package com.alonelaval.cornerstone.service.org.appointment;

import com.alonelaval.cornerstone.entity.biz.OrgDisposeAppointment;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgDisposeAppointmentService  extends IBaseService<OrgDisposeAppointment,Integer> {
    default void addOrgDisposeAppointment(OrgDisposeAppointment orgDisposeAppointment) throws Exception{
   }

}