package com.alonelaval.cornerstone.service.org.employee;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeWorkday;
import com.alonelaval.cornerstone.entity.model.OrgEmployeeWorktimeModel;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgEmployeeWorkdayService  extends IBaseService<OrgEmployeeWorkday,Integer> {
    default OrgEmployeeWorkday addOrgEmployeeWorkday(OrgEmployeeWorkday orgEmployeeWorkday) throws Exception{
        return  add(orgEmployeeWorkday);
    }
    List<OrgEmployeeWorkday> addWorkdays(List<OrgEmployeeWorktimeModel> models, OrgEmployee employee)throws  Exception;

    List<OrgEmployeeWorkday> findAllByEmployeId(Integer integer)throws Exception;

}