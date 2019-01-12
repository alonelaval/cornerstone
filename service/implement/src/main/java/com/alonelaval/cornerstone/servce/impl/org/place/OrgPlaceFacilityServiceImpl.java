package com.alonelaval.cornerstone.servce.impl.org.place;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.google.common.collect.Lists;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgPlaceFacilityDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.biz.Facility;
import com.alonelaval.cornerstone.entity.biz.OrgPlace;
import com.alonelaval.cornerstone.entity.biz.OrgPlaceFacility;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.OrgPlaceFacilityModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.place.OrgPlaceFacilityService;
import com.alonelaval.cornerstone.service.platform.FacilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgPlaceFacilityService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgPlaceFacilityServiceImpl extends AbstractBaseService<OrgPlaceFacility,Integer> implements OrgPlaceFacilityService {
    @Autowired
    OrgPlaceFacilityDao orgPlaceFacilityDao;
    @Autowired
    FacilityService facilityService;


  	@Override
    public Page<OrgPlaceFacility> findByModelAndPage(Model model, Page<OrgPlaceFacility> page) throws Exception {
        OrgPlaceFacilityModel orgPlaceFacilityModel = (OrgPlaceFacilityModel) model;
        WhereBuilder builder = WhereBuilder.build();
        return orgPlaceFacilityDao.findAllByPredicateAndPage(builder.predicate(),page);
    }
    
    @Override
    protected IBaseDao<OrgPlaceFacility,Integer> getBaseDao() {
        return orgPlaceFacilityDao;
    }

    @Override
    public List<OrgPlaceFacility> addOrgPlaceFacility(OrgPlace orgPlace, List<Integer> facilityIds) throws Exception {
  	    if(facilityIds !=null ){
  	        List<OrgPlaceFacility> orgPlaceFacilities = Lists.newArrayList();

  	        List<Facility> facilities = facilityService.findAllByIds(facilityIds);
  	        for(Facility facility: facilities){
  	            OrgPlaceFacility orgPlaceFacility = OrgPlaceFacility.builder()
                        .facilityId(facility.getFacilityId())
                        .facilityName(facility.getFacilityName())
                        .firstCategoryId(facility.getFirstCategoryId())
                        .firstCategoryName(facility.getFirstCategoryName())
                        .secondCategoryId(facility.getSecondCategoryId())
                        .secondCategoryName(facility.getSecondCategoryName())
                        .placeId(orgPlace.getPlaceId())
                        .placeName(orgPlace.getPlaceName())
                        .orgId(orgPlace.getOrgId())
                        .orgName(orgPlace.getOrgName())
                        .build();
                SetEntityProperties.getInstance().setProperties(orgPlaceFacility);
                orgPlaceFacilities.add(this.add(orgPlaceFacility));
            }
            return  orgPlaceFacilities;
        }
        return Collections.emptyList();
    }
}
