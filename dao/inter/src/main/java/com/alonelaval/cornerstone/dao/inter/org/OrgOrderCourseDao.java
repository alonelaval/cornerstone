package com.alonelaval.cornerstone.dao.inter.org;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.OrgOrderCourse;
import com.alonelaval.cornerstone.entity.constants.IsArrangeClass;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface OrgOrderCourseDao  extends IBaseDao<OrgOrderCourse,Integer> {

    List<OrgOrderCourse> findAllByCourseIdAndIsArrangeClass(Integer courseId, IsArrangeClass isArrangeClass) throws DaoException;

}
