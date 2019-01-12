package com.alonelaval.cornerstone.dao.impl.org.course;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.org.OrgCoursePlaceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgCoursePlaceRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgCoursePlaceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgCoursePlaceRepository;
import com.alonelaval.cornerstone.entity.biz.OrgCoursePlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgCoursePlaceDao")
public class OrgCoursePlaceDaoImpl extends AbstractBaseDao<OrgCoursePlace,Integer> implements OrgCoursePlaceDao {

    @Autowired
    OrgCoursePlaceRepository orgCoursePlaceRepository;

    @Override
    protected BaseRepository<OrgCoursePlace, Integer> getBaseRepository() {
        return orgCoursePlaceRepository;
    }

    @Override
    public OrgCoursePlace findPlaceByPlaceIdAndCourseId(Integer placeId, Integer courseId) throws DaoException {
        return orgCoursePlaceRepository.findOneByPlaceIdAndCourseId(placeId,courseId);
    }
}
