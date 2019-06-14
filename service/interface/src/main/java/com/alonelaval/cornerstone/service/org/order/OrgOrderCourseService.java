package com.alonelaval.cornerstone.service.org.order;

import com.alonelaval.cornerstone.entity.biz.*;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgOrderCourseService  extends IBaseService<OrgOrderCourse,Integer> {
    default OrgOrderCourse addOrgOrderCourse(OrgOrderCourse orgOrderCourse) throws Exception{
        return  this.add(orgOrderCourse);
   }

    /**
     * 添加订单时，添加该订单的课程信息
     * @param orgCourse 课程
     * @param orgOrder 订单
     * @param orgStudent 学员
     * @param user  下单用户
     * @param coursePrice  单价，课时
     * @param orgCoursePlace  上课地点
     * @return
     * @throws Exception
     */
   OrgOrderCourse addOrderCourse(OrgCourse orgCourse, OrgOrder orgOrder, OrgStudent orgStudent,User user,
                                 OrgCoursePrice coursePrice,OrgCoursePlace orgCoursePlace)throws  Exception;

    /**
     * 查找该门课程没有排课的学员
     * @param courseId
     * @return
     * @throws Exception
     */
   List<OrgOrderCourse> findNotArrangeOrderCourse(Integer courseId)throws  Exception;

    /**
     * 查找该门课程，没有排课的学员，并且上课时间是在某个时间点内的，比如
     * 小王在周一的下午3点到4点上课，排课时排到周一的下午3点到4点，找出这个时间点所以未排课的学员
     * @param courseId
     * @param cpId
     * @return
     * @throws Exception
     */
   List<OrgOrderCourse> findNotArrangeOrderCourseAndPeriod(Integer courseId,Integer cpId)throws  Exception;
}