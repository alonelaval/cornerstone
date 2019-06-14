package com.alonelaval.cornerstone.servce.impl.org.place;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.exception.ExceptionUtil;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgPlaceDao;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.OrgPlace;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.OrgPlaceModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.place.OrgPlaceFacilityService;
import com.alonelaval.cornerstone.service.org.place.OrgPlaceService;
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
@Service("orgPlaceService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgPlaceServiceImpl extends AbstractBaseService<OrgPlace,Integer> implements OrgPlaceService {
    @Autowired
    OrgPlaceDao orgPlaceDao;
    @Autowired
    OrgPlaceFacilityService orgPlaceFacilityService;


    @Override
    public OrgPlace add(Model model) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        OrgPlaceModel orgPlaceModel = (OrgPlaceModel) model;

        if(this.findOneByPlaceNameAndOrgId(orgPlaceModel.getPlaceName(),userAdapter.getOrg().get().getOrgId())
                .isPresent()){
            ExceptionUtil.throwServiceException(ExceptionType.NAME_EXIST_EXCEPTION);
        }
        OrgPlace orgPlace = OrgPlace.builder()
                .orgId(userAdapter.getOrg().get().getOrgId())
                .orgName(userAdapter.getOrg().get().getOrgName())
                .address(orgPlaceModel.getAddress())
                .placeFullName(orgPlaceModel.getPlaceFullName())
                .address(orgPlaceModel.getAddress())
                .area(orgPlaceModel.getArea())
                .beginUseDate(orgPlaceModel.getBeginUseDate())
                .endUseDate(orgPlaceModel.getEndUseDate())
                .province(orgPlaceModel.getProvince())
                .city(orgPlaceModel.getCity())
                .county(orgPlaceModel.getCounty())
                .ownType(orgPlaceModel.getOwnType())
                .remark(orgPlaceModel.getRemark())
                .xCoord(orgPlaceModel.getXCoord())
                .yCoord(orgPlaceModel.getYCoord())
                .placeName(orgPlaceModel.getPlaceName())
                .build();
        SetEntityProperties.getInstance().setProperties(orgPlace);

        orgPlace = this.add(orgPlace);

        orgPlaceFacilityService.addOrgPlaceFacility(orgPlace,orgPlaceModel.getFacilityIds());


        return orgPlace;
    }

    @Override
    protected IBaseDao<OrgPlace,Integer> getBaseDao() {
        return orgPlaceDao;
    }

    @Override
    public Optional<OrgPlace> findOneByPlaceNameAndOrgId(String placeName, Integer orgId) throws Exception {
        return orgPlaceDao.findOneByPlaceNameAndOrgId(placeName,orgId);
    }
}
