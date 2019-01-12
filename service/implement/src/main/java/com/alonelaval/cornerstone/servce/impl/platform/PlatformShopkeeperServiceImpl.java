package com.alonelaval.cornerstone.servce.impl.platform;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.platform.PlatformShopkeeperDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.biz.*;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.AuditState;
import com.alonelaval.cornerstone.entity.constants.ProductVersion;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.PlatformShopkeeperModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.platform.PlatformShopkeeperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("platformShopkeeperService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class PlatformShopkeeperServiceImpl extends AbstractBaseService<PlatformShopkeeper,Integer> implements PlatformShopkeeperService {
    @Autowired
    PlatformShopkeeperDao platformShopkeeperDao;



    @Override
    public Page<PlatformShopkeeper> findByModelAndPage(Model model, Page<PlatformShopkeeper> page) throws Exception {

        PlatformShopkeeperModel platformShopkeeperModel = (PlatformShopkeeperModel) model;
        WhereBuilder builder = WhereBuilder.build();


        if(platformShopkeeperModel.getState() == null ){
            builder.in(QPlatformShopkeeper.platformShopkeeper.state,State.ENABLED,State.DISABLED);
        }else
        {
            builder.and(QPlatformShopkeeper.platformShopkeeper.state.eq(platformShopkeeperModel.getState()));
        }

        builder.and(QPlatformShopkeeper.platformShopkeeper.productVersion,platformShopkeeperModel.getProductVersion());
        builder.and(QPlatformShopkeeper.platformShopkeeper.auditState,platformShopkeeperModel.getAuditState());
        builder.startWith(QPlatformShopkeeper.platformShopkeeper.userName,platformShopkeeperModel.getUserName());
        builder.startWith(QPlatformShopkeeper.platformShopkeeper.phone,platformShopkeeperModel.getPhone());

        return platformShopkeeperDao.findAllByPredicateAndPage(builder.predicate(),page);
    }

    @Override
    protected IBaseDao<PlatformShopkeeper,Integer> getBaseDao() {
        return platformShopkeeperDao;
    }

    @Override
    public PlatformShopkeeper addShopkeeper(Org org, User user, OrgEmployee orgEmployee) throws Exception {
        PlatformShopkeeper shopkeeper = PlatformShopkeeper.builder()
                .userId(user.getUserId())
                .userName(user.getUserRealName())
                .auditState(AuditState.WAIT_AUDIT)
                .phone(user.getPhone())
                .productVersion(ProductVersion.TEST)
                .orgCount((short) 1)
                .orgId(org.getOrgId())
                .orgName(org.getOrgName())
                .employeId(orgEmployee.getEmployeId())
                .build();

        SetEntityProperties.getInstance().setProperties(shopkeeper);
        return addPlatformShopkeeper(shopkeeper);
    }

    @Override
    public PlatformShopkeeper findByUserId(Integer userId) throws Exception {
        return platformShopkeeperDao.findByUserId(userId);
    }
}
