package com.alonelaval.cornerstone.dao.impl.org.course;

import com.alonelaval.cornerstone.dao.inter.org.OrgCoursePriceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgCoursePriceRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgCoursePriceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgCoursePriceRepository;
import com.alonelaval.cornerstone.entity.biz.OrgCoursePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgCoursePriceDao")
public class OrgCoursePriceDaoImpl  extends AbstractBaseDao<OrgCoursePrice,Integer> implements OrgCoursePriceDao {

    @Autowired
    OrgCoursePriceRepository orgCoursePriceRepository;

    @Override
    protected BaseRepository<OrgCoursePrice, Integer> getBaseRepository() {
        return orgCoursePriceRepository;
    }
}
