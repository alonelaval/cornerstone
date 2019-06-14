package com.alonelaval.cornerstone.service.org.course;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.OrgCourseClassType;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgCourseClassTypeService  extends IBaseService<OrgCourseClassType,Integer> {
    default OrgCourseClassType addOrgCourseClassType(OrgCourseClassType orgCourseClassType) throws Exception{
        return  add(orgCourseClassType);
   }

}