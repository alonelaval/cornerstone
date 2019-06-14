package com.alonelaval.cornerstone.servce.impl.platform;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.exception.ExceptionUtil;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.platform.AreaDao;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.Area;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
import com.alonelaval.cornerstone.entity.model.AreaModel;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.platform.AreaService;
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
@Service("areaService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class AreaServiceImpl extends AbstractBaseService<Area,Integer> implements AreaService {
    @Autowired
    AreaDao areaDao;


    @Override
    public Area add(Model model) throws Exception {
        AreaModel areaModel = (AreaModel) model;

        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        if(userAdapter.getLoginType().equals(RoleOwnType.PLATFORM_ROLE)){

            Area area = Area.builder()
                    .adminDivision(areaModel.getAdminDivision())
                    .zipCode(areaModel.getZipCode())
                    .areaName(areaModel.getAreaName())
                    .level((byte) 1)
                    .build();
            String areaCode = "";
            if(areaModel.getParentAreaId()!=null){
                Optional<Area> parent = areaDao.findById(areaModel.getParentAreaId());
                if(parent.isPresent()){
                    area.setParentAreaId(parent.get().getParentAreaId());
                    area.setParentAreaName(parent.get().getParentAreaName());
                    area.setLevel((byte) (parent.get().getLevel()+1));
                    areaCode =parent.get().getAreaCode();
                }
            }
            SetEntityProperties.getInstance().setProperties(area);

            area = this.add(area);

            area.setAreaCode(areaCode.isEmpty()? area.getAreaId()+"" : areaCode.concat(".").concat(area.getAreaId()+""));

            return  update(area);
        }
        ExceptionUtil.throwServiceException(ExceptionType.NOT_AUTH);

        return  null;
    }

    @Override
    protected IBaseDao<Area,Integer> getBaseDao() {
        return areaDao;
    }
}
