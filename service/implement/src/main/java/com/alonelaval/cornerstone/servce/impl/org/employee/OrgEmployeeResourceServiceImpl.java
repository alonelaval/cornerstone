package com.alonelaval.cornerstone.servce.impl.org.employee;

import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeResourceDao;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeResource;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgEmployeeResourceService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgEmployeeResourceServiceImpl extends AbstractBaseService<OrgEmployeeResource,Integer>  implements OrgEmployeeResourceService {
    @Autowired
    OrgEmployeeResourceDao orgEmployeeResourceDao;
    

    @Override
    protected IBaseDao<OrgEmployeeResource,Integer> getBaseDao() {
        return orgEmployeeResourceDao;
    }
}
