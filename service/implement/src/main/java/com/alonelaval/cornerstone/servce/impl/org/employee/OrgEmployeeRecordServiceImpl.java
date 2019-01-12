package com.alonelaval.cornerstone.servce.impl.org.employee;

import com.google.common.collect.Lists;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeRecordDao;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeRecord;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.model.OrgEmployeeRecordModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgEmployeeRecordService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgEmployeeRecordServiceImpl extends AbstractBaseService<OrgEmployeeRecord,Integer>  implements OrgEmployeeRecordService {
    @Autowired
    OrgEmployeeRecordDao orgEmployeeRecordDao;
    

    @Override
    protected IBaseDao<OrgEmployeeRecord,Integer> getBaseDao() {
        return orgEmployeeRecordDao;
    }


    @Override
    public OrgEmployeeRecord addRecord(OrgEmployeeRecordModel recordModel, OrgEmployee employee) throws Exception {
        OrgEmployeeRecord orgEmployeeRecord = OrgEmployeeRecord.builder()
                .beginDate(recordModel.getBeginDate())
                .endDate(recordModel.getEndDate())
                .recordName(recordModel.getRecordName())
                .employeId(employee.getEmployeId())
                .orgId(employee.getOrgId())
                .orgName(employee.getOrgName())
                .userId(employee.getUserId())
                .userName(employee.getUserName())
                .build();

        SetEntityProperties.getInstance().setProperties(orgEmployeeRecord);
        return add(orgEmployeeRecord);
    }

    @Override
    public List<OrgEmployeeRecord> addRecords(List<OrgEmployeeRecordModel> orgEmployeeRecordModels, OrgEmployee orgEmployee) throws Exception {
        List<OrgEmployeeRecord>  records = Lists.newArrayList();
        if(orgEmployeeRecordModels != null && !orgEmployeeRecordModels.isEmpty()){
            for(OrgEmployeeRecordModel orgEmployeeRecordModel : orgEmployeeRecordModels){
                records.add(addRecord(orgEmployeeRecordModel,orgEmployee));
            }
        }
        return records;
    }
}
