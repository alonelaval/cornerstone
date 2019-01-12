package com.alonelaval.cornerstone.servce.impl.org.course;

import com.google.common.collect.Lists;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgCoursePeriodDao;
import com.alonelaval.cornerstone.entity.biz.OrgCourse;
import com.alonelaval.cornerstone.entity.biz.OrgCoursePeriod;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.model.OrgCoursePeriodModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.course.OrgCoursePeriodService;
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
@Service("orgCoursePeriodService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgCoursePeriodServiceImpl extends AbstractBaseService<OrgCoursePeriod,Integer>  implements OrgCoursePeriodService {
    @Autowired
    OrgCoursePeriodDao orgCoursePeriodDao;
    


    @Override
    protected IBaseDao<OrgCoursePeriod,Integer> getBaseDao() {
        return orgCoursePeriodDao;
    }

    @Override
    public List<OrgCoursePeriod> addCoursePeriod(List<OrgCoursePeriodModel> periodModels, OrgCourse orgCourse) throws Exception {
        List<OrgCoursePeriod> list = Lists.newArrayList();
        if(periodModels!= null && !periodModels.isEmpty()){
            for (OrgCoursePeriodModel model : periodModels){
                OrgCoursePeriod orgCoursePeriod = OrgCoursePeriod.builder()
                        .beginTime(model.getBeginTime())
                        .endTime(model.getEndTime())
                        .dayType(model.getDayType())
                        .orgId(orgCourse.getOrgId())
                        .orgName(orgCourse.getOrgName())
                        .courseId(orgCourse.getCourseId())
                        .courseName(orgCourse.getCourseName())
                        .build();
                SetEntityProperties.getInstance().setProperties(orgCoursePeriod);

                list.add(add(orgCoursePeriod));

            }
        }
        return list;
    }

    @Override
    public List<OrgCoursePeriod> findPeriodsByCourseId(Integer courseId) throws Exception {
        return orgCoursePeriodDao.findPeriodsByCourseId(courseId);
    }

    @Override
    public OrgCoursePeriod findPeriodByIdAndCourseId(Integer cpId, Integer courseId) throws Exception {
        return orgCoursePeriodDao.findPeriodByIdAndCourseId(cpId,courseId);
    }
}
