package com.alonelaval.cornerstone.servce.impl.org.course;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.google.common.collect.Lists;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgCourseResourceDao;
import com.alonelaval.cornerstone.entity.biz.OrgCourse;
import com.alonelaval.cornerstone.entity.biz.OrgCourseResource;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.CourseResourceType;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.course.OrgCourseResourceService;
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
@Service("orgCourseResourceService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgCourseResourceServiceImpl extends AbstractBaseService<OrgCourseResource,Integer> implements OrgCourseResourceService {
    @Autowired
    OrgCourseResourceDao orgCourseResourceDao;
    

    @Override
    protected IBaseDao<OrgCourseResource,Integer> getBaseDao() {
        return orgCourseResourceDao;
    }

    @Override
    public List<OrgCourseResource> addResource(List<String> resourceFileNames, OrgCourse orgCourse) throws Exception {
        List<OrgCourseResource> list = Lists.newArrayList();
        if(resourceFileNames!= null && !resourceFileNames.isEmpty()){
            for (String resourceFile : resourceFileNames){

                OrgCourseResource orgCourseResource = OrgCourseResource.builder()
                        .resourcePath(resourceFile)
                        .resourceType(CourseResourceType.PICTURE)
                        .orgId(orgCourse.getOrgId())
                        .orgName(orgCourse.getOrgName())
                        .courseId(orgCourse.getCourseId())
                        .courseName(orgCourse.getCourseName())
                        .build();

                SetEntityProperties.getInstance().setProperties(orgCourseResource);
                list.add(add(orgCourseResource));
            }
        }
        return list;
    }
}
