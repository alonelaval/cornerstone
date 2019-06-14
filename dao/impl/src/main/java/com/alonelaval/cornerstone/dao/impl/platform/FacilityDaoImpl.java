package com.alonelaval.cornerstone.dao.impl.platform;


import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.platform.FacilityDao;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.FacilityRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.platform.FacilityDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.FacilityRepository;
import com.alonelaval.cornerstone.entity.biz.Facility;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="facilityDao")
public class FacilityDaoImpl  extends AbstractBaseDao<Facility,Integer> implements FacilityDao {

    @Autowired
    FacilityRepository facilityRepository;

    @Override
    protected BaseRepository<Facility, Integer> getBaseRepository() {
        return facilityRepository;
    }

    @Override
    public Optional<Facility> findOneByFacilityName(String facilityName) throws DaoException {
        try {
            return Optional.ofNullable(facilityRepository.findOneByFacilityName(facilityName));
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }
}
