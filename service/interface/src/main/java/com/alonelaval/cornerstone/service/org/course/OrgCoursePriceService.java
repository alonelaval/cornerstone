package com.alonelaval.cornerstone.service.org.course;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.OrgCourse;
import com.alonelaval.cornerstone.entity.biz.OrgCoursePrice;
import com.alonelaval.cornerstone.entity.model.OrgCoursePriceModel;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgCoursePriceService  extends IBaseService<OrgCoursePrice,Integer> {
    default OrgCoursePrice addOrgCoursePrice(OrgCoursePrice orgCoursePrice) throws Exception{
        return add(orgCoursePrice);
   }
    List<OrgCoursePrice> addCoursePrice(List<OrgCoursePriceModel> priceModels, OrgCourse orgCourse)throws  Exception;
}