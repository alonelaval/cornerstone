package com.alonelaval.cornerstone.dao.inter.org;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.OrgCourse;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface OrgCourseDao  extends IBaseDao<OrgCourse,Integer> {
    OrgCourse findOneByNameAndOrgId(String courseName, Integer orgId)throws DaoException;
}
