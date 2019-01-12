package com.alonelaval.cornerstone.service.org.employee;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeRecord;
import com.alonelaval.cornerstone.entity.model.OrgEmployeeRecordModel;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgEmployeeRecordService  extends IBaseService<OrgEmployeeRecord,Integer> {
    default OrgEmployeeRecord addOrgEmployeeRecord(OrgEmployeeRecord orgEmployeeRecord) throws Exception{
        return  add(orgEmployeeRecord);
   }

    OrgEmployeeRecord addRecord(OrgEmployeeRecordModel recordModel, OrgEmployee employee)throws  Exception;
    List<OrgEmployeeRecord> addRecords(List<OrgEmployeeRecordModel> orgEmployeeRecordModels,
                                       OrgEmployee orgEmployee)throws  Exception;
}