package com.alonelaval.cornerstone.service.org.order;

import com.alonelaval.cornerstone.entity.biz.OrgOrderCourse;
import com.alonelaval.cornerstone.entity.biz.OrgOrderCoursePeriod;
import com.alonelaval.cornerstone.entity.biz.User;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgOrderCoursePeriodService  extends IBaseService<OrgOrderCoursePeriod,Integer> {
    default OrgOrderCoursePeriod addOrgOrderCousePeriod(OrgOrderCoursePeriod orgOrderCousePeriod) throws Exception{
        return  this.addOrgOrderCousePeriod(orgOrderCousePeriod);
    }


    /**
     * 允许设置上课时间的课程
     * @param coursePeriodIds
     * @param orgOrderCourse
     * @param user
     * @return
     * @throws Exception
     */
    List<OrgOrderCoursePeriod> addCoursePeriod(List<Integer> coursePeriodIds, OrgOrderCourse orgOrderCourse,
                                              User user)throws  Exception;

    /**
     * 不允许设置上课时间的课程
     * @param orgOrderCourse
     * @param user
     * @return
     * @throws Exception
     */
    List<OrgOrderCoursePeriod> addCoursePeriod(OrgOrderCourse orgOrderCourse, User user)throws Exception;

    /**
     * 查找某个时间的用户
     * @param courseId
     * @param cpId
     * @param userIds
     * @return
     * @throws Exception
     */
    List<OrgOrderCoursePeriod> findAllByCourseIdAndCpIdAndUserIdIn(Integer courseId, Integer cpId, List<Integer> userIds) throws Exception;
}