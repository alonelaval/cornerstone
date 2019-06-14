package com.alonelaval.cornerstone.servce.impl.org.course;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.google.common.collect.Lists;
import com.alonelaval.common.util.AmountPriceUtil;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgCoursePriceDao;
import com.alonelaval.cornerstone.entity.biz.OrgCourse;
import com.alonelaval.cornerstone.entity.biz.OrgCoursePrice;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.model.OrgCoursePriceModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.course.OrgCoursePriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgCoursePriceService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgCoursePriceServiceImpl extends AbstractBaseService<OrgCoursePrice,Integer> implements OrgCoursePriceService {
    @Autowired
    OrgCoursePriceDao orgCoursePriceDao;


    @Override
    protected IBaseDao<OrgCoursePrice,Integer> getBaseDao() {
        return orgCoursePriceDao;
    }

    @Override
    public List<OrgCoursePrice> addCoursePrice(List<OrgCoursePriceModel> priceModels, OrgCourse orgCourse) throws Exception {
        List<OrgCoursePrice> list = Lists.newArrayList();
        if(priceModels!= null && !priceModels.isEmpty()){
            for (OrgCoursePriceModel model : priceModels){

                OrgCoursePrice orgCoursePrice = OrgCoursePrice.builder()
                        .courseCount(model.getClassCount())
                        .courseTime(model.getClassTime())
                        .price(AmountPriceUtil.input(model.getPrice()))
                        .totalCourseTime(model.getTotalClassTime())
                        .orgId(orgCourse.getOrgId())
                        .orgName(orgCourse.getOrgName())
                        .courseId(orgCourse.getCourseId())
                        .courseName(orgCourse.getCourseName())
                        .build();

                SetEntityProperties.getInstance().setProperties(orgCoursePrice);
                list.add(add(orgCoursePrice));
            }
        }
        return list;
    }
}
