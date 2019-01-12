package com.alonelaval.cornerstone.servce.impl.org.place;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.google.common.collect.Lists;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.VmOrgPlaceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.biz.*;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.VmOrgPlaceModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.place.VmOrgPlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("vmOrgPlaceService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class VmOrgPlaceServiceImpl extends AbstractBaseService<VmOrgPlace,Integer> implements VmOrgPlaceService {
    @Autowired
    VmOrgPlaceDao vmOrgPlaceDao;
    


  	@Override
    public Page<VmOrgPlace> findByModelAndPage(Model model, Page page) throws Exception {
        VmOrgPlaceModel vmOrgPlaceModel = (VmOrgPlaceModel) model;
        WhereBuilder builder = WhereBuilder.build();

        if(vmOrgPlaceModel.getState() == null ){
            builder.in(QVmOrgPlace.vmOrgPlace.state,State.ENABLED,State.DISABLED);
        }else
        {
            builder.and(QVmOrgPlace.vmOrgPlace.state.eq(vmOrgPlaceModel.getState()));
        }

        builder.startWith(QVmOrgPlace.vmOrgPlace.placeName,vmOrgPlaceModel.getPlaceName());
        builder.and(QVmOrgPlace.vmOrgPlace.facilityId,vmOrgPlaceModel.getFacilityId());
        builder.andBetweenNumber(QVmOrgPlace.vmOrgPlace.area,vmOrgPlaceModel.getMinArea(),vmOrgPlaceModel.getMaxArea());

        page  =vmOrgPlaceDao.findAllByPredicateAndPage(builder.predicate(),page);

        List<VmOrgPlace> placeList = page.getData();

        Map<Integer,List<VmOrgPlace>> orgPlaceMap= placeList.stream().collect(groupingBy(VmOrgPlace::getPlaceId));


        List<OrgPlace> orgPlaces = Lists.newArrayList();

        for(Map.Entry<Integer,List<VmOrgPlace>> entry:orgPlaceMap.entrySet()){
            OrgPlace orgPlace = OrgPlace.builder().build();
            VmOrgPlace vmOrgPlace = entry.getValue().get(0);
            BeanUtils.copyProperties(vmOrgPlace,orgPlace);

            List<OrgPlaceFacility> orgPlaceFacilities = Lists.newArrayList();
            for(VmOrgPlace temp : entry.getValue()){
                OrgPlaceFacility orgPlaceFacility = OrgPlaceFacility.builder().build();

                BeanUtils.copyProperties(temp,orgPlaceFacility);
                orgPlaceFacilities.add(orgPlaceFacility);
            }
            orgPlace.setOrgPlaceFacilities(orgPlaceFacilities);

            orgPlaces.add(orgPlace);
        }

        page.setData(orgPlaces);
        return page;
    }
    
    @Override
    protected IBaseDao<VmOrgPlace,Integer> getBaseDao() {
        return vmOrgPlaceDao;
    }
}
