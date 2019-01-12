package com.alonelaval.cornerstone.dao.repository.jpa.biz;


import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.entity.biz.OrgCoursePlace;
import org.springframework.stereotype.Repository;

/**
 * @author huawei
 * @create 2018-07-111
 * create by python 
 **/
@Repository
public interface OrgCoursePlaceRepository extends BaseRepository<OrgCoursePlace,Integer> {
    OrgCoursePlace findOneByPlaceIdAndCourseId(Integer placeId,Integer courseId);
}
