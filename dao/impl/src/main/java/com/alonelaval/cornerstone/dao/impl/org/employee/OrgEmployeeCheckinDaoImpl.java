package com.alonelaval.cornerstone.dao.impl.org.employee;

import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeCheckinDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgEmployeeCheckinRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeCheckinDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgEmployeeCheckinRepository;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeCheckin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgEmployeeCheckinDao")
public class OrgEmployeeCheckinDaoImpl  extends AbstractBaseDao<OrgEmployeeCheckin,Integer> implements OrgEmployeeCheckinDao {

    @Autowired
    OrgEmployeeCheckinRepository orgEmployeeCheckinRepository;

    @Override
    protected BaseRepository<OrgEmployeeCheckin, Integer> getBaseRepository() {
        return orgEmployeeCheckinRepository;
    }
}
