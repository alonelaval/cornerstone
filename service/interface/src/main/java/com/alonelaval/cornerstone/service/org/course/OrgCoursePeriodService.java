package com.alonelaval.cornerstone.service.org.course;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.OrgCourse;
import com.alonelaval.cornerstone.entity.biz.OrgCoursePeriod;
import com.alonelaval.cornerstone.entity.model.OrgCoursePeriodModel;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgCoursePeriodService  extends IBaseService<OrgCoursePeriod,Integer> {
    default OrgCoursePeriod addOrgCoursePeriod(OrgCoursePeriod orgCoursePeriod) throws Exception{
        return  add(orgCoursePeriod);
   }
    List<OrgCoursePeriod> addCoursePeriod(List<OrgCoursePeriodModel> periodModels, OrgCourse orgCourse)throws  Exception;

    /**
     * 查找某个课程的上课周期
     * @param courseId
     * @return
     * @throws Exception
     */
    List<OrgCoursePeriod> findPeriodsByCourseId(Integer courseId)throws  Exception;

    OrgCoursePeriod findPeriodByIdAndCourseId(Integer cpId,Integer courseId)throws Exception;

}