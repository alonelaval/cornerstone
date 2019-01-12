package com.alonelaval.cornerstone.servce.impl.org;

import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgResourceDao;
import com.alonelaval.cornerstone.entity.biz.Org;
import com.alonelaval.cornerstone.entity.biz.OrgResource;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.OrgResourceType;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.OrgResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgResourceService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgResourceServiceImpl extends AbstractBaseService<OrgResource,Integer>  implements OrgResourceService {
    @Autowired
    OrgResourceDao orgResourceDao;
    

    @Override
    protected IBaseDao<OrgResource,Integer> getBaseDao() {
        return orgResourceDao;
    }

    @Override
    public List<OrgResource> addOrgResource(List<String> resourceFiles, Org org, OrgResourceType type) throws Exception {

        if(Optional.ofNullable(resourceFiles).isPresent()){
            return getOrgResources(resourceFiles, org, type);
        }
        return Collections.EMPTY_LIST;
    }

    private List<OrgResource> getOrgResources(List<String> resourceFiles, Org org, OrgResourceType type) throws Exception {
        List<OrgResource> list = new ArrayList<>();
        for(String resourceFile : resourceFiles){
            OrgResource orgResource = OrgResource.builder().orgId(org.getOrgId()).resourceName(type.desc())
                    .resourcePath(resourceFile)
                    .resourceType(type).build();

            SetEntityProperties.getInstance().setProperties(orgResource);

            list.add(addOrgResource(orgResource));
        }
        return list;
    }

    @Override
    public List<OrgResource> updateOrgResource(List<String> resourceFiles, Org org, OrgResourceType type) throws Exception {

        if(Optional.ofNullable(resourceFiles).isPresent()){
            orgResourceDao.updateStateByOrgId(org.getOrgId(),State.DELETE);
            return getOrgResources(resourceFiles, org, type);
        }
        return Collections.EMPTY_LIST;
    }
}
