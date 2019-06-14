package com.alonelaval.cornerstone.dao.repository.jpa.biz;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.entity.biz.OrgCoursePeriod;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-111
 * create by python 
 **/
@Repository
public interface OrgCoursePeriodRepository extends BaseRepository<OrgCoursePeriod,Integer> {
    List<OrgCoursePeriod> findAllByCourseId(Integer courseId);

    OrgCoursePeriod findByCpIdAndCourseId(Integer cpId,Integer courseId)throws DaoException;

}
