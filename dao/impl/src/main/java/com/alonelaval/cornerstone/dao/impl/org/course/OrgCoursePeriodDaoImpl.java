package com.alonelaval.cornerstone.dao.impl.org.course;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.org.OrgCoursePeriodDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgCoursePeriodRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgCoursePeriodDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgCoursePeriodRepository;
import com.alonelaval.cornerstone.entity.biz.OrgCoursePeriod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgCoursePeriodDao")
public class OrgCoursePeriodDaoImpl  extends AbstractBaseDao<OrgCoursePeriod,Integer> implements OrgCoursePeriodDao {

    @Autowired
    OrgCoursePeriodRepository orgCoursePeriodRepository;

    @Override
    protected BaseRepository<OrgCoursePeriod, Integer> getBaseRepository() {
        return orgCoursePeriodRepository;
    }

    @Override
    public List<OrgCoursePeriod> findPeriodsByCourseId(Integer courseId) throws DaoException {
        return orgCoursePeriodRepository.findAllByCourseId(courseId);
    }

    @Override
    public OrgCoursePeriod findPeriodByIdAndCourseId(Integer cpId, Integer courseId) throws DaoException {
        return orgCoursePeriodRepository.findByCpIdAndCourseId(cpId,courseId);
    }
}
