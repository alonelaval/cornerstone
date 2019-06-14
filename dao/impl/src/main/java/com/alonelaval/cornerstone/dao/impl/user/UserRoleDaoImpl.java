package com.alonelaval.cornerstone.dao.impl.user;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.UserRoleDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.UserRoleRepository;
import com.alonelaval.cornerstone.entity.biz.UserRole;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="userRoleDao")
public class UserRoleDaoImpl  extends AbstractBaseDao<UserRole,Integer> implements UserRoleDao {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    protected BaseRepository<UserRole, Integer> getBaseRepository() {
        return userRoleRepository;
    }

    @Override
    public List<UserRole> findRoleByUserId(Integer userId)throws DaoException {
        try {
            return userRoleRepository.findAllByUserId(userId);
        }catch (Exception e){
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(),e.getMessage(),e);
        }

    }

    @Override
    public List<UserRole> findRoleByUserIdAndOrgIdIsNull(Integer userId) throws DaoException {
        try {
            return userRoleRepository.findAllByUserIdAndOrgIdIsNull(userId);
        }catch (Exception e){
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(),e.getMessage(),e);
        }

    }

    @Override
    public List<UserRole> findRoleByUserIdAndOrgId(Integer userId, Integer orgId) throws DaoException{
        try{
            return userRoleRepository.findAllByUserIdAndOrgId(userId,orgId);
        }catch (Exception e){
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(),e.getMessage(),e);
        }
    }

    @Override
    public List<UserRole> findAllByUserIdAndOwnTypeAndOrgId(Integer userId, RoleOwnType ownType, Integer orgId)  throws DaoException{
        try{
            return userRoleRepository.findAllByUserIdAndOwnTypeAndOrgId(userId,ownType,orgId);
        }catch (Exception e){
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(),e.getMessage(),e);
        }
    }

    @Override
    public List<UserRole> findAllByUserIdAndOwnTypeAndOrgIdAndFormRoleIdIn(Integer userId, RoleOwnType ownType, Integer orgId, List<Integer> fromRoleIds) throws DaoException {
        try{
            return userRoleRepository.findAllByUserIdAndOwnTypeAndOrgId(userId,ownType,orgId);
        }catch (Exception e){
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(),e.getMessage(),e);
        }
    }

    @Override
    public List<UserRole> findAllByUserIdAndOwnType(Integer userId, RoleOwnType ownType)  throws DaoException{
        try{
            return userRoleRepository.findAllByUserIdAndOwnType(userId,ownType);
        }catch (Exception e){
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(),e.getMessage(),e);
        }
    }

    @Override
    public List<UserRole> findAllByUserIdAndOwnTypeAndOrgIdAndRoleIdIn(Integer userId, RoleOwnType ownType, Integer orgId, List<Integer> roleIds) throws DaoException {
        try{
            return userRoleRepository.findAllByUserIdAndOwnTypeAndOrgIdAndRoleIdIn(userId,ownType,orgId,roleIds);
        }catch (Exception e){
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(),e.getMessage(),e);
        }
    }
}
