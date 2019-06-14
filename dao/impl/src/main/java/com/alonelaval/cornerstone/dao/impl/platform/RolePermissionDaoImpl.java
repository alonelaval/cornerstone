package com.alonelaval.cornerstone.dao.impl.platform;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.platform.RolePermissionDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.RolePermissionRepository;
import com.alonelaval.cornerstone.entity.biz.RolePermission;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="rolePermissionDao")
public class RolePermissionDaoImpl  extends AbstractBaseDao<RolePermission,Integer> implements RolePermissionDao {

    @Autowired
    RolePermissionRepository rolePermissionRepository;

    @Override
    protected BaseRepository<RolePermission, Integer> getBaseRepository() {
        return rolePermissionRepository;
    }

    @Override
    public List<RolePermission> findAllByRoleIdIn(List<Integer> ids ) throws DaoException {
        try {
            return rolePermissionRepository.findAllByRoleIdIn(ids);
        }catch (Exception e){
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(),e.getMessage(),e);
        }

    }

    @Override
    public List<RolePermission> addRolePermission(List<RolePermission> rolePermissions) throws DaoException {
        try {
            return rolePermissionRepository.saveAll(rolePermissions);
        }catch (Exception e){
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(),e.getMessage(),e);
        }
    }
}
