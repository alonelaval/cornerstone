package com.alonelaval.cornerstone.dao.impl.org;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgRepository;
import com.alonelaval.cornerstone.entity.biz.Org;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgDao")
public class OrgDaoImpl  extends AbstractBaseDao<Org,Integer> implements OrgDao {

    @Autowired
    OrgRepository orgRepository;

    @Override
    protected BaseRepository<Org, Integer> getBaseRepository() {
        return orgRepository;
    }

    @Override
    public Org findOrgByOrgName(String orgName) throws DaoException {
        try {
            return  orgRepository.findOrgByOrgName(orgName);
        }catch (Exception e){
            throw  new DaoException(e.getMessage(),e);
        }
    }
}
