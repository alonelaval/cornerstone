package com.alonelaval.cornerstone.dao.impl.org.employee;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgEmployeeRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgEmployeeRepository;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.constants.IsCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgEmployeeDao")
public class OrgEmployeeDaoImpl  extends AbstractBaseDao<OrgEmployee,Integer> implements OrgEmployeeDao {

    @Autowired
    OrgEmployeeRepository orgEmployeeRepository;

    @Override
    protected BaseRepository<OrgEmployee, Integer> getBaseRepository() {
        return orgEmployeeRepository;
    }

    @Override
    public OrgEmployee findByOrgIdAndUserId(Integer orgId, Integer userId)throws DaoException {
        try {
            return orgEmployeeRepository.findByOrgIdAndUserId(orgId,userId);
        }catch (Exception e){
            throw  new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public List<OrgEmployee> findAllByOrgId(Integer orgId) throws DaoException {
        try {
            return orgEmployeeRepository.findAllByOrgId(orgId);
        }catch (Exception e){
            throw  new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public List<OrgEmployee> findAllByEmployeIdsAndIsCoach(List<Integer> employeIds, IsCoach isCoach) throws DaoException {
        try {
            return orgEmployeeRepository.findAllByEmployeIdInAndIsCoach(employeIds,isCoach);
        }catch (Exception e){
            throw  new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public List<OrgEmployee> findAllByOrgIdAndIsCoach(Integer orgId,IsCoach isCoach) throws DaoException {
        try {
            return orgEmployeeRepository.findAllByOrgIdAndIsCoach(orgId,isCoach);
        }catch (Exception e){
            throw  new DaoException(e.getMessage(),e);
        }
    }
}
