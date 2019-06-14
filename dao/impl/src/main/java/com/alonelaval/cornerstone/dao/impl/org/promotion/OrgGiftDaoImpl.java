package com.alonelaval.cornerstone.dao.impl.org.promotion;

import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgGiftDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgGiftRepository;
import com.alonelaval.cornerstone.entity.biz.OrgGift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgGiftDao")
public class OrgGiftDaoImpl  extends AbstractBaseDao<OrgGift,Integer> implements OrgGiftDao {

    @Autowired
    OrgGiftRepository orgGiftRepository;

    @Override
    protected BaseRepository<OrgGift, Integer> getBaseRepository() {
        return orgGiftRepository;
    }
}
