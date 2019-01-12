package com.alonelaval.cornerstone.dao.impl.org.employee;

import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeRecordDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgEmployeeRecordRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeRecordDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgEmployeeRecordRepository;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgEmployeeRecordDao")
public class OrgEmployeeRecordDaoImpl  extends AbstractBaseDao<OrgEmployeeRecord,Integer> implements OrgEmployeeRecordDao {

    @Autowired
    OrgEmployeeRecordRepository orgEmployeeRecordRepository;

    @Override
    protected BaseRepository<OrgEmployeeRecord, Integer> getBaseRepository() {
        return orgEmployeeRecordRepository;
    }
}
