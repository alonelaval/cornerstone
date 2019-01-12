package com.alonelaval.cornerstone.dao.impl.org.classes;

import com.alonelaval.cornerstone.dao.inter.org.OrgClassStudentDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgClassStudentRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgClassStudentDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgClassStudentRepository;
import com.alonelaval.cornerstone.entity.biz.OrgClassStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgClassStudentDao")
public class OrgClassStudentDaoImpl  extends AbstractBaseDao<OrgClassStudent,Integer> implements OrgClassStudentDao {

    @Autowired
    OrgClassStudentRepository orgClassStudentRepository;

    @Override
    protected BaseRepository<OrgClassStudent, Integer> getBaseRepository() {
        return orgClassStudentRepository;
    }
}
