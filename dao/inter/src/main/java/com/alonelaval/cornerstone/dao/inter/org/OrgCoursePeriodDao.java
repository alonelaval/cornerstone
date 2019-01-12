package com.alonelaval.cornerstone.dao.inter.org;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.OrgCoursePeriod;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface OrgCoursePeriodDao  extends IBaseDao<OrgCoursePeriod,Integer> {

    List<OrgCoursePeriod> findPeriodsByCourseId(Integer courseId) throws DaoException;

    OrgCoursePeriod findPeriodByIdAndCourseId(Integer cpId, Integer courseId)throws DaoException;
}
