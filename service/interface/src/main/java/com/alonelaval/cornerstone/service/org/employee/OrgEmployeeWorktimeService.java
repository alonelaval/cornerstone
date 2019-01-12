package com.alonelaval.cornerstone.service.org.employee;

import com.alonelaval.cornerstone.entity.biz.OrgEmployeeWorkday;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeWorktime;
import com.alonelaval.cornerstone.entity.model.OrgEmployeeWorktimeModel;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgEmployeeWorktimeService  extends IBaseService<OrgEmployeeWorktime,Integer> {
    default OrgEmployeeWorktime addOrgEmployeeWorktime(OrgEmployeeWorktime orgEmployeeWorktime) throws Exception{
        return  add(orgEmployeeWorktime);
   }
    List<OrgEmployeeWorktime> addWorkTime(List<OrgEmployeeWorktimeModel> models, OrgEmployeeWorkday workday)throws  Exception;

}