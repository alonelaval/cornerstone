package com.alonelaval.cornerstone.dao.impl.platform;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.platform.RoleDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.RoleRepository;
import com.alonelaval.cornerstone.entity.biz.Role;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.RoleCreateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value = "roleDao")
public class RoleDaoImpl extends AbstractBaseDao<Role, Integer> implements RoleDao {

    @Autowired
    RoleRepository roleRepository;

    @Override
    protected BaseRepository<Role, Integer> getBaseRepository() {
        return roleRepository;
    }

    @Override
    public Optional<List<Role>> findByIds(List<Integer> ids) throws DaoException {
        try {
            return Optional.ofNullable(roleRepository.findAllByRoleIdIn(ids));
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }

    @Override
    public Optional<List<Role>> findByOrgId(Integer orgId) throws DaoException {
        try {
            return Optional.ofNullable(roleRepository.findAllByOrgId(orgId));
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }

    @Override
    public Optional<List<Role>> findByOrgIdAndFromRoleId(Integer orgId,List<Integer> fromRoleIds) throws DaoException {
        try {
            return Optional.ofNullable(roleRepository.findAllByOrgIdAndFromRoleIdIn(orgId,fromRoleIds));
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }

    @Override
    public Optional<List<Role>> findByOrgIdAndFromRoleIdNotNull(Integer orgId) throws DaoException {
        try {
            return Optional.ofNullable(roleRepository.findAllByOrgIdAndFromRoleIdNotNull(orgId));
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }

    @Override
    public Optional<List<Role>>  findByOrgIdAndCreateType(Integer orgId, RoleCreateType roleCreateType) throws DaoException {
        try {
            return Optional.ofNullable(roleRepository.findByOrgIdAndCreateType(orgId,roleCreateType));
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }
}
