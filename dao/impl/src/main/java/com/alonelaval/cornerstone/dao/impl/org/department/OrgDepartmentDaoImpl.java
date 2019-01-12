package com.alonelaval.cornerstone.dao.impl.org.department;

import com.alonelaval.cornerstone.dao.inter.org.OrgDepartmentDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgDepartmentRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgDepartmentDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgDepartmentRepository;
import com.alonelaval.cornerstone.entity.biz.OrgDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgDepartmentDao")
public class OrgDepartmentDaoImpl  extends AbstractBaseDao<OrgDepartment,Integer> implements OrgDepartmentDao {

    @Autowired
    OrgDepartmentRepository orgDepartmentRepository;

    @Override
    protected BaseRepository<OrgDepartment, Integer> getBaseRepository() {
        return orgDepartmentRepository;
    }
}
