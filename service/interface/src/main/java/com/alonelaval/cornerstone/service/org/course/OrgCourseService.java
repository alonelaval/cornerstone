package com.alonelaval.cornerstone.service.org.course;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.OrgCourse;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgCourseService  extends IBaseService<OrgCourse,Integer> {
    default OrgCourse addOrgCourse(OrgCourse orgCourse) throws Exception{
        return this.add(orgCourse);
   }

   OrgCourse findOneByNameAndOrgId(String courseName,Integer orgId)throws  Exception;
}