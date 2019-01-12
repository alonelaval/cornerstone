package com.alonelaval.cornerstone.dao.impl.org;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.org.OrgPermissionDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgPermissionRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgPermissionDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgPermissionRepository;
import com.alonelaval.cornerstone.entity.biz.OrgPermission;
import com.alonelaval.cornerstone.entity.constants.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgPermissionDao")
public class OrgPermissionDaoImpl  extends AbstractBaseDao<OrgPermission,Integer> implements OrgPermissionDao {

    @Autowired
    OrgPermissionRepository orgPermissionRepository;

    @Override
    protected BaseRepository<OrgPermission, Integer> getBaseRepository() {
        return orgPermissionRepository;
    }

    @Override
    public List<OrgPermission> findAllByOpIdIn(List<Integer> ids) throws DaoException {
        try {
            return  orgPermissionRepository.findAllByOpIdIn(ids);
        }catch (Exception e){
            throw  new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public List<OrgPermission> addOrgPermissions(List<OrgPermission> orgPermissions) throws DaoException {
        try {
           return orgPermissionRepository.saveAll(orgPermissions);
        }catch (Exception e){
            throw  new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public void updateAllByOrgId(List<Integer> ids, Integer orgId,State state) throws DaoException {
        try {
             orgPermissionRepository.updateStateByOrgIdAndPermissionIds(ids,orgId,state.value());
        }catch (Exception e){
            throw  new DaoException(e.getMessage(),e);
        }
    }
}
