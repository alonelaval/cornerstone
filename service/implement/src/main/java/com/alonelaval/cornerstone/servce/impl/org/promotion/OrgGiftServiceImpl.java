package com.alonelaval.cornerstone.servce.impl.org.promotion;

import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgGiftDao;
import com.alonelaval.cornerstone.entity.biz.OrgGift;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.promotion.OrgGiftService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgGiftService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgGiftServiceImpl extends AbstractBaseService<OrgGift,Integer>  implements OrgGiftService
{
    @Autowired
    OrgGiftDao orgGiftDao;
    

    @Override
    protected IBaseDao<OrgGift,Integer> getBaseDao() {
        return orgGiftDao;
    }
}
