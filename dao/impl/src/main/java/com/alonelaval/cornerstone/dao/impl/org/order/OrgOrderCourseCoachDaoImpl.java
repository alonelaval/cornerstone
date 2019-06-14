package com.alonelaval.cornerstone.dao.impl.org.order;

import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgOrderCourseCoachDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgOrderCourseCoachRepository;
import com.alonelaval.cornerstone.entity.biz.OrgOrderCourseCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgOrderCourseCoachDao")
public class OrgOrderCourseCoachDaoImpl  extends AbstractBaseDao<OrgOrderCourseCoach,Integer> implements OrgOrderCourseCoachDao {

    @Autowired
    OrgOrderCourseCoachRepository orgOrderCourseCoachRepository;

    @Override
    protected BaseRepository<OrgOrderCourseCoach, Integer> getBaseRepository() {
        return orgOrderCourseCoachRepository;
    }
}
