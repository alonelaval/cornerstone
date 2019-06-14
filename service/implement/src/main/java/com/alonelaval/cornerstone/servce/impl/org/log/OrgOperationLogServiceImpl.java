package com.alonelaval.cornerstone.servce.impl.org.log;

import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OperationLogDao;
import com.alonelaval.cornerstone.entity.biz.OperationLog;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.log.OperationLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgOperationLogService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgOperationLogServiceImpl extends AbstractBaseService<OperationLog,Integer>  implements OperationLogService {
    @Autowired
    OperationLogDao orgOperationLogDao;
    

    @Override
    protected IBaseDao<OperationLog,Integer> getBaseDao() {
        return orgOperationLogDao;
    }
}
