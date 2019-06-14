package com.alonelaval.cornerstone.servce.impl.org;

import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgRelationDao;
import com.alonelaval.cornerstone.entity.biz.OrgRelation;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.OrgRelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgRelationService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgRelationServiceImpl extends AbstractBaseService<OrgRelation,Integer>  implements OrgRelationService {
    @Autowired
    OrgRelationDao orgRelationDao;
    

    @Override
    protected IBaseDao<OrgRelation,Integer> getBaseDao() {
        return orgRelationDao;
    }
}
