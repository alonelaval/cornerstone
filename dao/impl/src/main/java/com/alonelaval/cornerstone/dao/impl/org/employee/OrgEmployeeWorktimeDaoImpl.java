package com.alonelaval.cornerstone.dao.impl.org.employee;

import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeWorktimeDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgEmployeeWorktimeRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeWorktimeDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgEmployeeWorktimeRepository;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeWorktime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgEmployeeWorktimeDao")
public class OrgEmployeeWorktimeDaoImpl  extends AbstractBaseDao<OrgEmployeeWorktime,Integer> implements OrgEmployeeWorktimeDao {

    @Autowired
    OrgEmployeeWorktimeRepository orgEmployeeWorktimeRepository;

    @Override
    protected BaseRepository<OrgEmployeeWorktime, Integer> getBaseRepository() {
        return orgEmployeeWorktimeRepository;
    }
}
