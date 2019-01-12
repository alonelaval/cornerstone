package com.alonelaval.cornerstone.dao.impl.org;

import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgRelationDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgRelationRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgRelationDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgRelationRepository;
import com.alonelaval.cornerstone.entity.biz.OrgRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgRelationDao")
public class OrgRelationDaoImpl  extends AbstractBaseDao<OrgRelation,Integer> implements OrgRelationDao {

    @Autowired
    OrgRelationRepository orgRelationRepository;

    @Override
    protected BaseRepository<OrgRelation, Integer> getBaseRepository() {
        return orgRelationRepository;
    }
}
