package com.alonelaval.cornerstone.servce.impl.org.place;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgPlaceResourceDao;
import com.alonelaval.cornerstone.entity.biz.OrgPlaceResource;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.place.OrgPlaceResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgPlaceResourceService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgPlaceResourceServiceImpl extends AbstractBaseService<OrgPlaceResource,Integer> implements OrgPlaceResourceService {
    @Autowired
    OrgPlaceResourceDao orgPlaceResourceDao;
    

    @Override
    protected IBaseDao<OrgPlaceResource,Integer> getBaseDao() {
        return orgPlaceResourceDao;
    }
}
