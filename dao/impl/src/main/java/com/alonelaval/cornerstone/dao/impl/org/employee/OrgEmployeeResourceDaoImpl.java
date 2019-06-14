package com.alonelaval.cornerstone.dao.impl.org.employee;

import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeResourceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgEmployeeResourceRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeResourceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgEmployeeResourceRepository;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgEmployeeResourceDao")
public class OrgEmployeeResourceDaoImpl  extends AbstractBaseDao<OrgEmployeeResource,Integer> implements OrgEmployeeResourceDao {

    @Autowired
    OrgEmployeeResourceRepository orgEmployeeResourceRepository;

    @Override
    protected BaseRepository<OrgEmployeeResource, Integer> getBaseRepository() {
        return orgEmployeeResourceRepository;
    }
}
