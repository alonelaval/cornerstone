package com.alonelaval.cornerstone.dao.impl.org.log;

import com.alonelaval.cornerstone.dao.inter.org.OperationLogDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OperationLogRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OperationLogDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OperationLogRepository;
import com.alonelaval.cornerstone.entity.biz.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgOperationLogDao")
public class OperationLogDaoImpl  extends AbstractBaseDao<OperationLog,Integer> implements OperationLogDao {

    @Autowired
    OperationLogRepository operationLogRepository;

    @Override
    protected BaseRepository<OperationLog, Integer> getBaseRepository() {
        return operationLogRepository;
    }
}
