package com.alonelaval.cornerstone.servce.impl.platform;

import com.alonelaval.common.exception.ExceptionUtil;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.cache.CourseCategoryCache;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.platform.FacilityDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.biz.Facility;
import com.alonelaval.cornerstone.entity.biz.QFacility;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.entity.model.FacilityModel;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.platform.FacilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("facilityService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class FacilityServiceImpl extends AbstractBaseService<Facility,Integer> implements FacilityService {
    @Autowired
    FacilityDao facilityDao;

    @Override
    public Facility add(Model model) throws Exception {
        FacilityModel facilityModel = (FacilityModel) model;

        if(this.findOneByFacilityName(facilityModel.getFacilityName()).isPresent()){
            ExceptionUtil.throwServiceException(ExceptionType.NAME_EXIST_EXCEPTION);
        }

        Facility facility = Facility.builder()
                .facilityName(facilityModel.getFacilityName())
                .secondCategoryId(facilityModel.getSecondCategoryId())
                .secondCategoryName(CourseCategoryCache.getInstance().get(facilityModel.getSecondCategoryId())
                        .getCategoryName())
                .firstCategoryId(CourseCategoryCache.getInstance().get(CourseCategoryCache.getInstance()
                        .get(facilityModel.getSecondCategoryId()).getParentCategoryId()).getCategoryId())
                .firstCategoryName(CourseCategoryCache.getInstance().get(CourseCategoryCache.getInstance()
                        .get(facilityModel.getSecondCategoryId()).getParentCategoryId()).getCategoryName())
                .build();
        SetEntityProperties.getInstance().setProperties(facility);

        return this.add(facility);
    }

    @Override
    public Page<Facility> findByModelAndPage(Model model, Page<Facility> page) throws Exception {
        FacilityModel facilityModel = (FacilityModel) model;
        WhereBuilder builder = WhereBuilder.build();

        if(facilityModel.getState() == null ){
            builder.in(QFacility.facility.state,State.ENABLED,State.DISABLED);
        }else
        {
            builder.and(QFacility.facility.state.eq(facilityModel.getState()));
        }
        builder.startWith(QFacility.facility.facilityName,facilityModel.getFacilityName());
        builder.in(QFacility.facility.secondCategoryId,facilityModel.getSecondCategoryIds());

        return facilityDao.findAllByPredicateAndPage(builder.predicate(),page);
    }
    
    @Override
    protected IBaseDao<Facility,Integer> getBaseDao() {
        return facilityDao;
    }

    @Override
    public Optional<Facility> findOneByFacilityName(String facilityName) throws Exception {
        return facilityDao.findOneByFacilityName(facilityName);
    }
}
