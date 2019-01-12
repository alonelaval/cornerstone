package com.alonelaval.cornerstone.servce.impl.org;

import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgPermissionDao;
import com.alonelaval.cornerstone.entity.biz.Org;
import com.alonelaval.cornerstone.entity.biz.OrgPermission;
import com.alonelaval.cornerstone.entity.biz.SysPermission;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.OrgPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgPermissionService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgPermissionServiceImpl extends AbstractBaseService<OrgPermission,Integer>  implements OrgPermissionService {
    @Autowired
    OrgPermissionDao orgPermissionDao;
    

    @Override
    protected IBaseDao<OrgPermission,Integer> getBaseDao() {
        return orgPermissionDao;
    }

    @Override
    public List<OrgPermission> findAllByOpIdIn(List<Integer> ids) throws Exception {
        return Optional.of(orgPermissionDao.findAllByOpIdIn(ids)).orElse(Collections.emptyList());
    }

    @Override
    public List<OrgPermission> addOrgPermissionsBySysPermissions(List<SysPermission> sysPermissions, Org org) throws Exception {

        List<OrgPermission> orgPermissions = newArrayList();
        for(SysPermission sysPermission : sysPermissions){
            OrgPermission orgPermission = new OrgPermission();
            BeanUtils.copyProperties(sysPermission,orgPermission);
            orgPermission.setOrgId(org.getOrgId());
            orgPermission.setOrgName(org.getOrgName());
            orgPermission.setState(State.ENABLED);
            orgPermission.setCreateTime(LocalDateTime.now());
            orgPermissions.add(orgPermission);
        }
        return Optional.of(orgPermissionDao.addOrgPermissions(orgPermissions)).orElse(Collections.emptyList());
    }

    @Override
    public List<OrgPermission> addOrgPermissions(List<OrgPermission> orgPermissions) throws Exception {
        return  orgPermissionDao.addOrgPermissions(orgPermissions);
    }

    @Override
    public void deleteAllByOrgId(List<Integer> ids, Integer orgId) throws Exception {
        orgPermissionDao.updateAllByOrgId(ids,orgId,State.DELETE);
    }

    @Override
    public void enableAllByOrgId(List<Integer> ids, Integer orgId) throws Exception {
        orgPermissionDao.updateAllByOrgId(ids,orgId,State.ENABLED);
    }
}
