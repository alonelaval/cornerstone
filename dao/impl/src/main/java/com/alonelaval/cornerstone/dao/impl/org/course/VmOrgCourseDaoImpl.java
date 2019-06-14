package com.alonelaval.cornerstone.dao.impl.org.course;


import com.alonelaval.cornerstone.dao.inter.org.VmOrgCourseDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.VmOrgCourseRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.VmOrgCourseDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.VmOrgCourseRepository;
import com.alonelaval.cornerstone.entity.biz.VmOrgCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="vmOrgCourseDao")
public class VmOrgCourseDaoImpl  extends AbstractBaseDao<VmOrgCourse,Integer> implements VmOrgCourseDao {

    @Autowired
    VmOrgCourseRepository vmOrgCourseRepository;

    @Override
    protected BaseRepository<VmOrgCourse, Integer> getBaseRepository() {
        return vmOrgCourseRepository;
    }
}
