package com.alonelaval.cornerstone.dao.impl.org.order;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgOrderCourseDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgOrderCourseRepository;
import com.alonelaval.cornerstone.entity.biz.OrgOrderCourse;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.IsArrangeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgOrderCourseDao")
public class OrgOrderCourseDaoImpl  extends AbstractBaseDao<OrgOrderCourse,Integer> implements OrgOrderCourseDao {

    @Autowired
    OrgOrderCourseRepository orgOrderCourseRepository;

    @Override
    protected BaseRepository<OrgOrderCourse, Integer> getBaseRepository() {
        return orgOrderCourseRepository;
    }

    @Override
    public List<OrgOrderCourse> findAllByCourseIdAndIsArrangeClass(Integer courseId, IsArrangeClass isArrangeClass) throws DaoException {
        try {
            return orgOrderCourseRepository.findAllByCourseIdAndIsArrangeClass(courseId,isArrangeClass);
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }
}
