package com.alonelaval.cornerstone.dao.inter.org;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.OrgOrderCoursePeriod;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface OrgOrderCoursePeriodDao  extends IBaseDao<OrgOrderCoursePeriod,Integer> {

    List<OrgOrderCoursePeriod> findAllByCourseIdAndCpIdAndUserIdIn(Integer courseId, Integer cpId, List<Integer> userIds)throws DaoException;
}
