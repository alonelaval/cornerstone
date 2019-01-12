package com.alonelaval.cornerstone.dao.impl.org.place;

import com.alonelaval.cornerstone.dao.inter.org.VmOrgPlaceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.VmOrgPlaceRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.VmOrgPlaceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.VmOrgPlaceRepository;
import com.alonelaval.cornerstone.entity.biz.VmOrgPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="vmOrgPlaceDao")
public class VmOrgPlaceDaoImpl  extends AbstractBaseDao<VmOrgPlace,Integer> implements VmOrgPlaceDao {

    @Autowired
    VmOrgPlaceRepository vmOrgPlaceRepository;

    @Override
    protected BaseRepository<VmOrgPlace, Integer> getBaseRepository() {
        return vmOrgPlaceRepository;
    }
}
