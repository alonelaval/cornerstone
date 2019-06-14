package com.alonelaval.cornerstone.dao.impl.org.place;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.org.OrgPlaceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgPlaceRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgPlaceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgPlaceRepository;
import com.alonelaval.cornerstone.entity.biz.OrgPlace;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgPlaceDao")
public class OrgPlaceDaoImpl  extends AbstractBaseDao<OrgPlace,Integer> implements OrgPlaceDao {

    @Autowired
    OrgPlaceRepository orgPlaceRepository;

    @Override
    protected BaseRepository<OrgPlace, Integer> getBaseRepository() {
        return orgPlaceRepository;
    }

    @Override
    public Optional<OrgPlace> findOneByPlaceNameAndOrgId(String placeName, Integer orgId) throws DaoException {
        try {
            return Optional.ofNullable(orgPlaceRepository.findOneByPlaceNameAndOrgId(placeName,orgId));
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }
}
