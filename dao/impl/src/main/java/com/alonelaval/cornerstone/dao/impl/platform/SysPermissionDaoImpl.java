package com.alonelaval.cornerstone.dao.impl.platform;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.platform.SysPermissionDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.SysPermissionRepository;
import com.alonelaval.cornerstone.entity.biz.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="sysPermissionDao")
public class SysPermissionDaoImpl  extends AbstractBaseDao<SysPermission,Integer> implements SysPermissionDao {

    @Autowired
    SysPermissionRepository sysPermissionRepository;

    @Override
    protected BaseRepository<SysPermission, Integer> getBaseRepository() {
        return sysPermissionRepository;
    }

    @Override
    public List<SysPermission> findAllByPermissionIdIn(List<Integer> ids)throws DaoException {
        try {
            return  sysPermissionRepository.findAllByPermissionIdIn(ids);
        }catch (Exception e){
            throw  new DaoException(e.getMessage(),e);
        }
    }
}
