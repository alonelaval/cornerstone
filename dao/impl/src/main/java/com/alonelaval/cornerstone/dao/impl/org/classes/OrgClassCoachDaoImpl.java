package com.alonelaval.cornerstone.dao.impl.org.classes;

import com.alonelaval.cornerstone.dao.inter.org.OrgClassCoachDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgClassCoachRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgClassCoachDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgClassCoachRepository;
import com.alonelaval.cornerstone.entity.biz.OrgClassCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgClassCoachDao")
public class OrgClassCoachDaoImpl  extends AbstractBaseDao<OrgClassCoach,Integer> implements OrgClassCoachDao {

    @Autowired
    OrgClassCoachRepository orgClassCoachRepository;

    @Override
    protected BaseRepository<OrgClassCoach, Integer> getBaseRepository() {
        return orgClassCoachRepository;
    }
}
