package com.alonelaval.cornerstone.servce.impl.message;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.SysMessageDao;
import com.alonelaval.cornerstone.entity.biz.SysMessage;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.message.SysMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("sysMessageService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class SysMessageServiceImpl extends AbstractBaseService<SysMessage,Integer> implements SysMessageService {
    @Autowired
    SysMessageDao sysMessageDao;
    

    @Override
    protected IBaseDao<SysMessage,Integer> getBaseDao() {
        return sysMessageDao;
    }
}
