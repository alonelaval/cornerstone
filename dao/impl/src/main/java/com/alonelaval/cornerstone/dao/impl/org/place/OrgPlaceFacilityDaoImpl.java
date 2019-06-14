package com.alonelaval.cornerstone.dao.impl.org.place;

import com.alonelaval.cornerstone.dao.inter.org.OrgPlaceFacilityDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgPlaceFacilityRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgPlaceFacilityDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgPlaceFacilityRepository;
import com.alonelaval.cornerstone.entity.biz.OrgPlaceFacility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgPlaceFacilityDao")
public class OrgPlaceFacilityDaoImpl  extends AbstractBaseDao<OrgPlaceFacility,Integer> implements OrgPlaceFacilityDao {

    @Autowired
    OrgPlaceFacilityRepository orgPlaceFacilityRepository;

    @Override
    protected BaseRepository<OrgPlaceFacility, Integer> getBaseRepository() {
        return orgPlaceFacilityRepository;
    }
}
