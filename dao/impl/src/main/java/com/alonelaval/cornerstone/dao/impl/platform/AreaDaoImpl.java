package com.alonelaval.cornerstone.dao.impl.platform;

import com.alonelaval.cornerstone.dao.inter.platform.AreaDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.AreaRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.platform.AreaDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.AreaRepository;
import com.alonelaval.cornerstone.entity.biz.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="areaDao")
public class AreaDaoImpl  extends AbstractBaseDao<Area,Integer> implements AreaDao {

    @Autowired
    AreaRepository areaRepository;

    @Override
    protected BaseRepository<Area, Integer> getBaseRepository() {
        return areaRepository;
    }
}
