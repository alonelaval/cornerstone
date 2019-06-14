package com.alonelaval.cornerstone.servce.impl.org.student;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgReturnVisitDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.OrgReturnVisit;
import com.alonelaval.cornerstone.entity.biz.QOrgReturnVisit;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.OrgReturnVisitModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.student.OrgReturnVisitService;
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
@Service("orgReturnVisitService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgReturnVisitServiceImpl extends AbstractBaseService<OrgReturnVisit,Integer>  implements OrgReturnVisitService {
    @Autowired
    OrgReturnVisitDao orgReturnVisitDao;


    @Override
    public Page<OrgReturnVisit> findByModelAndPage(Model model, Page<OrgReturnVisit> page) throws Exception {
        OrgReturnVisitModel orgReturnVisitModel = (OrgReturnVisitModel) model;
        WhereBuilder builder = WhereBuilder.build();


        if(orgReturnVisitModel.getState() == null ){
            builder.in(QOrgReturnVisit.orgReturnVisit.state,State.ENABLED,State.DISABLED);
        }else
        {
            builder.and(QOrgReturnVisit.orgReturnVisit.state.eq(orgReturnVisitModel.getState()));
        }

        builder.and(QOrgReturnVisit.orgReturnVisit.orgId,orgReturnVisitModel.getOrgId());
        builder.and(QOrgReturnVisit.orgReturnVisit.visitType,orgReturnVisitModel.getVisitType());
        builder.startWith(QOrgReturnVisit.orgReturnVisit.visitUserName,orgReturnVisitModel.getVisitUserName());
        builder.and(QOrgReturnVisit.orgReturnVisit.userName,orgReturnVisitModel.getUserName());

        builder.andBetweenTime(QOrgReturnVisit.orgReturnVisit.visitTime,orgReturnVisitModel.getBeginVisitTime()
                ,orgReturnVisitModel.getEndVisitTime());

        return orgReturnVisitDao.findAllByPredicateAndPage(builder.predicate(),page);
    }

    @Override
    public OrgReturnVisit update(Model model, Integer id) throws Exception {
        OrgReturnVisitModel orgReturnVisitModel = (OrgReturnVisitModel) model;
        Optional<OrgReturnVisit> optionalOrgReturnVisit = orgReturnVisitDao.findById(id);
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        if(optionalOrgReturnVisit.isPresent()){
            OrgReturnVisit visit = optionalOrgReturnVisit.get();
            visit.setVisitContent(orgReturnVisitModel.getVisitContent());
            visit.setVisitType(orgReturnVisitModel.getVisitType());
            visit.setVisitTime(orgReturnVisitModel.getVisitTime());

            setOrgReturnVisit(visit,userAdapter);
            return  this.update(visit);
        }

        return null;
    }

    private void setOrgReturnVisit(OrgReturnVisit orgReturnVisit, UserAdapter userAdapter){
        if(userAdapter.getOrg().isPresent()){
            orgReturnVisit.setVisitEmployeId(userAdapter.getOrgEmployee().getEmployeId());
            orgReturnVisit.setVisitUserName(userAdapter.getOrgEmployee().getUserName());
            orgReturnVisit.setOrgId(userAdapter.getOrg().get().getOrgId());
            orgReturnVisit.setOrgName(userAdapter.getOrg().get().getOrgName());
        }
    }

    @Override
    public OrgReturnVisit add(Model model) throws Exception {
        OrgReturnVisitModel orgReturnVisitModel = (OrgReturnVisitModel) model;
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        OrgReturnVisit orgReturnVisit = OrgReturnVisit.builder()
                .userId(orgReturnVisitModel.getUserId())
                .userName(orgReturnVisitModel.getUserName())
                .visitContent(orgReturnVisitModel.getVisitContent())
                .visitType(orgReturnVisitModel.getVisitType())
                .visitTime(orgReturnVisitModel.getVisitTime())
                .visitUserId(userAdapter.getUser().getUserId())
                .visitUserName(userAdapter.getUser().getUserRealName())
                .userPhone(orgReturnVisitModel.getUserPhone())
                .build();

        setOrgReturnVisit(orgReturnVisit,userAdapter);

        SetEntityProperties.getInstance().setProperties(orgReturnVisit);


        return this.add(orgReturnVisit);
    }

    @Override
    protected IBaseDao<OrgReturnVisit,Integer> getBaseDao() {
        return orgReturnVisitDao;
    }
}
