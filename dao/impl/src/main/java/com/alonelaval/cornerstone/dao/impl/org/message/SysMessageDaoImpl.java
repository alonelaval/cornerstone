package com.alonelaval.cornerstone.dao.impl.org.message;

import com.alonelaval.cornerstone.dao.inter.org.SysMessageDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.SysMessageRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.SysMessageDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.SysMessageRepository;
import com.alonelaval.cornerstone.entity.biz.SysMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="sysMessageDao")
public class SysMessageDaoImpl  extends AbstractBaseDao<SysMessage,Integer> implements SysMessageDao {

    @Autowired
    SysMessageRepository sysMessageRepository;

    @Override
    protected BaseRepository<SysMessage, Integer> getBaseRepository() {
        return sysMessageRepository;
    }
}
