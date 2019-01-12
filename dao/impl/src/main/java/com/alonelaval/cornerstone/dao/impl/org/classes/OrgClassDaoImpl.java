package com.alonelaval.cornerstone.dao.impl.org.classes;

import com.alonelaval.cornerstone.dao.inter.org.OrgClassDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgClassRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgClassDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgClassRepository;
import com.alonelaval.cornerstone.entity.biz.OrgClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgClassDao")
public class OrgClassDaoImpl  extends AbstractBaseDao<OrgClass,Integer> implements OrgClassDao {

    @Autowired
    OrgClassRepository orgClassRepository;

    @Override
    protected BaseRepository<OrgClass, Integer> getBaseRepository() {
        return orgClassRepository;
    }
}
