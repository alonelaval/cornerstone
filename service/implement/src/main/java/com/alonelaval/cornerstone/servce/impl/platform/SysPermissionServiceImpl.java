package com.alonelaval.cornerstone.servce.impl.platform;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.platform.SysPermissionDao;
import com.alonelaval.cornerstone.entity.biz.SysPermission;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.platform.SysPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("sysPermissionService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class SysPermissionServiceImpl extends AbstractBaseService<SysPermission,Integer> implements SysPermissionService {
    @Autowired
    SysPermissionDao sysPermissionDao;
    

    @Override
    protected IBaseDao<SysPermission,Integer> getBaseDao() {
        return sysPermissionDao;
    }

    @Override
    public List<SysPermission> findAllByPermissionIdIn(List<Integer> ids) throws Exception {
        return Optional.of(sysPermissionDao.findAllByPermissionIdIn(ids)).orElse(Collections.emptyList());
    }
}
