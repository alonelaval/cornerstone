package com.alonelaval.cornerstone.servce.impl.org.course;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.google.common.collect.Lists;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgCoursePlaceDao;
import com.alonelaval.cornerstone.entity.biz.OrgCourse;
import com.alonelaval.cornerstone.entity.biz.OrgCoursePlace;
import com.alonelaval.cornerstone.entity.biz.OrgPlace;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.course.OrgCoursePlaceService;
import com.alonelaval.cornerstone.service.org.place.OrgPlaceService;
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
@Service("orgCoursePlaceService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgCoursePlaceServiceImpl extends AbstractBaseService<OrgCoursePlace,Integer> implements OrgCoursePlaceService {
    @Autowired
    OrgCoursePlaceDao orgCoursePlaceDao;
    @Autowired
    OrgPlaceService orgPlaceService;
    

    @Override
    protected IBaseDao<OrgCoursePlace,Integer> getBaseDao() {
        return orgCoursePlaceDao;
    }

    @Override
    public OrgCoursePlace findPlaceByPlaceIdAndCourseId(Integer placeId, Integer courseId) throws Exception {
        return orgCoursePlaceDao.findPlaceByPlaceIdAndCourseId(placeId,courseId);
    }

    @Override
    public List<OrgCoursePlace> addPlace(List<Integer> placeIds, OrgCourse orgCourse) throws Exception {
        List<OrgCoursePlace> list = Lists.newArrayList();
        if(placeIds!= null && !placeIds.isEmpty()){
            List<OrgPlace> places = orgPlaceService.findAllByIds(placeIds);

            for (OrgPlace orgPlace : places){
                OrgCoursePlace orgCoursePlace = OrgCoursePlace.builder()
                        .placeId(orgPlace.getPlaceId())
                        .placeName(orgPlace.getPlaceName())
                        .orgId(orgCourse.getOrgId())
                        .orgName(orgCourse.getOrgName())
                        .courseId(orgCourse.getCourseId())
                        .courseName(orgCourse.getCourseName())
                        .build();
                SetEntityProperties.getInstance().setProperties(orgCoursePlace);
                list.add(add(orgCoursePlace));
            }
        }
        return list;
    }
}
