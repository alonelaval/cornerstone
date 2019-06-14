package com.alonelaval.cornerstone.service.platform;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.PlatformCourseCategory;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface PlatformCourseCategoryService  extends IBaseService<PlatformCourseCategory,Integer> {
    default PlatformCourseCategory addPlatformCourseCategory(PlatformCourseCategory platformCourseCategory) throws Exception{
        return platformCourseCategory;
   }

}