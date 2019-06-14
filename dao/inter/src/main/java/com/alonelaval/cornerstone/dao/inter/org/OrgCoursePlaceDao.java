package com.alonelaval.cornerstone.dao.inter.org;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.OrgCoursePlace;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface OrgCoursePlaceDao extends IBaseDao<OrgCoursePlace,Integer> {
    OrgCoursePlace findPlaceByPlaceIdAndCourseId(Integer placeId, Integer courseId)throws DaoException;
}
