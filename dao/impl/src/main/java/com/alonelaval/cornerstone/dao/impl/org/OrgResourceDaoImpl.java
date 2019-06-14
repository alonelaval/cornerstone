package com.alonelaval.cornerstone.dao.impl.org;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgResourceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgResourceRepository;
import com.alonelaval.cornerstone.entity.biz.OrgResource;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgResourceDao")
public class OrgResourceDaoImpl  extends AbstractBaseDao<OrgResource,Integer> implements OrgResourceDao {

    @Autowired
    OrgResourceRepository orgResourceRepository;

    @Override
    protected BaseRepository<OrgResource, Integer> getBaseRepository() {
        return orgResourceRepository;
    }

    @Override
    public void updateStateByOrgId(Integer orgId,State state) throws DaoException {
        try {
            orgResourceRepository.updateStateByOrgId(orgId,state.value());
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }
}
