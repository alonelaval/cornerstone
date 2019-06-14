package com.alonelaval.cornerstone.service.org.course;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.OrgCourse;
import com.alonelaval.cornerstone.entity.biz.OrgCoursePlace;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgCoursePlaceService extends IBaseService<OrgCoursePlace,Integer> {
    default OrgCoursePlace addOrgCoursePlace(OrgCoursePlace orgCoursePlace) throws Exception{
        return add(orgCoursePlace);
   }

   OrgCoursePlace findPlaceByPlaceIdAndCourseId(Integer placeId,Integer courseId)throws  Exception;


   List<OrgCoursePlace> addPlace(List<Integer> placeIds, OrgCourse orgCourse)throws  Exception;

}