package com.alonelaval.cornerstone.dao.impl.org.course;

import com.alonelaval.cornerstone.dao.inter.org.OrgCourseClassTypeDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgCourseClassTypeRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgCourseClassTypeDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgCourseClassTypeRepository;
import com.alonelaval.cornerstone.entity.biz.OrgCourseClassType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgCourseClassTypeDao")
public class OrgCourseClassTypeDaoImpl  extends AbstractBaseDao<OrgCourseClassType,Integer> implements OrgCourseClassTypeDao {

    @Autowired
    OrgCourseClassTypeRepository orgCourseClassTypeRepository;

    @Override
    protected BaseRepository<OrgCourseClassType, Integer> getBaseRepository() {
        return orgCourseClassTypeRepository;
    }
}
