package com.alonelaval.cornerstone.service.org.course;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.OrgCourse;
import com.alonelaval.cornerstone.entity.biz.OrgCourseResource;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgCourseResourceService  extends IBaseService<OrgCourseResource,Integer> {
    default OrgCourseResource addOrgCourseResource(OrgCourseResource orgCourseResource) throws Exception{
        return add(orgCourseResource);
   }

   List<OrgCourseResource> addResource(List<String> resourceFileNames, OrgCourse orgCourse)throws  Exception;

}