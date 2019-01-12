package com.alonelaval.cornerstone.dao.impl.org.course;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.org.OrgCourseDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgCourseRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgCourseDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgCourseRepository;
import com.alonelaval.cornerstone.entity.biz.OrgCourse;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgCourseDao")
public class OrgCourseDaoImpl  extends AbstractBaseDao<OrgCourse,Integer> implements OrgCourseDao {

    @Autowired
    OrgCourseRepository orgCourseRepository;

    @Override
    protected BaseRepository<OrgCourse, Integer> getBaseRepository() {
        return orgCourseRepository;
    }

    @Override
    public OrgCourse findOneByNameAndOrgId(String courseName, Integer orgId) throws DaoException {
        try{
            return orgCourseRepository.findOneByCourseNameAndOrgId(courseName,orgId);
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }
}
