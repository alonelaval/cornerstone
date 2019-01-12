package com.alonelaval.cornerstone.dao.impl.org.course;

import com.alonelaval.cornerstone.dao.inter.org.OrgCourseResourceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgCourseResourceRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgCourseResourceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgCourseResourceRepository;
import com.alonelaval.cornerstone.entity.biz.OrgCourseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgCourseResourceDao")
public class OrgCourseResourceDaoImpl  extends AbstractBaseDao<OrgCourseResource,Integer> implements OrgCourseResourceDao {

    @Autowired
    OrgCourseResourceRepository orgCourseResourceRepository;

    @Override
    protected BaseRepository<OrgCourseResource, Integer> getBaseRepository() {
        return orgCourseResourceRepository;
    }
}
