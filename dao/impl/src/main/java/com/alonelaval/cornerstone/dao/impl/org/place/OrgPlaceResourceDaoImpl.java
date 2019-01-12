package com.alonelaval.cornerstone.dao.impl.org.place;

import com.alonelaval.cornerstone.dao.inter.org.OrgPlaceResourceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgPlaceResourceRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgPlaceResourceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgPlaceResourceRepository;
import com.alonelaval.cornerstone.entity.biz.OrgPlaceResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgPlaceResourceDao")
public class OrgPlaceResourceDaoImpl  extends AbstractBaseDao<OrgPlaceResource,Integer> implements OrgPlaceResourceDao {

    @Autowired
    OrgPlaceResourceRepository orgPlaceResourceRepository;

    @Override
    protected BaseRepository<OrgPlaceResource, Integer> getBaseRepository() {
        return orgPlaceResourceRepository;
    }
}
