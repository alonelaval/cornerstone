package com.alonelaval.cornerstone.service.org.order;

import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.biz.OrgOrderCourse;
import com.alonelaval.cornerstone.entity.biz.OrgOrderCourseCoach;
import com.alonelaval.cornerstone.entity.biz.User;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgOrderCourseCoachService  extends IBaseService<OrgOrderCourseCoach,Integer> {
    default OrgOrderCourseCoach addOrgOrderCourseCoach(OrgOrderCourseCoach orgOrderCourseCoach) throws Exception{
        return  this.add(orgOrderCourseCoach);
   }


   OrgOrderCourseCoach addOrderCoach(OrgOrderCourse orgOrderCourse, OrgEmployee orgEmployee,User user)throws  Exception;

}