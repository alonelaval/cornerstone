package com.alonelaval.cornerstone.dao.impl.org.employee;

import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeSkillDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgEmployeeSkillRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeSkillDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgEmployeeSkillRepository;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgEmployeeSkillDao")
public class OrgEmployeeSkillDaoImpl  extends AbstractBaseDao<OrgEmployeeSkill,Integer> implements OrgEmployeeSkillDao {

    @Autowired
    OrgEmployeeSkillRepository orgEmployeeSkillRepository;

    @Override
    protected BaseRepository<OrgEmployeeSkill, Integer> getBaseRepository() {
        return orgEmployeeSkillRepository;
    }
}
