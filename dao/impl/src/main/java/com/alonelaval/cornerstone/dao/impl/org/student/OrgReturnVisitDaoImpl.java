package com.alonelaval.cornerstone.dao.impl.org.student;

import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgReturnVisitDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgReturnVisitRepository;
import com.alonelaval.cornerstone.entity.biz.OrgReturnVisit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgReturnVisitDao")
public class OrgReturnVisitDaoImpl  extends AbstractBaseDao<OrgReturnVisit,Integer> implements OrgReturnVisitDao {

    @Autowired
    OrgReturnVisitRepository orgReturnVisitRepository;

    @Override
    protected BaseRepository<OrgReturnVisit, Integer> getBaseRepository() {
        return orgReturnVisitRepository;
    }
}
