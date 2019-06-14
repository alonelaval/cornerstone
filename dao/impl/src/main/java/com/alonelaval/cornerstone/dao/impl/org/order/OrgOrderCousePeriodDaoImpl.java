package com.alonelaval.cornerstone.dao.impl.org.order;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgOrderCoursePeriodDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgOrderCoursePeriodRepository;
import com.alonelaval.cornerstone.entity.biz.OrgOrderCoursePeriod;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgOrderCousePeriodDao")
public class OrgOrderCousePeriodDaoImpl  extends AbstractBaseDao<OrgOrderCoursePeriod,Integer> implements OrgOrderCoursePeriodDao {

    @Autowired
    OrgOrderCoursePeriodRepository orgOrderCoursePeriodRepository;

    @Override
    protected BaseRepository<OrgOrderCoursePeriod, Integer> getBaseRepository() {
        return orgOrderCoursePeriodRepository;
    }

    @Override
    public List<OrgOrderCoursePeriod> findAllByCourseIdAndCpIdAndUserIdIn(Integer courseId, Integer cpId, List<Integer> userIds) throws DaoException {
        try {
            return orgOrderCoursePeriodRepository.findAllByCourseIdAndCpIdAndUserIdIn(courseId,cpId,userIds);
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }

    }
}
