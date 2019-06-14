package com.alonelaval.cornerstone.servce.impl.org.course;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgCourseClassTypeDao;
import com.alonelaval.cornerstone.entity.biz.OrgCourseClassType;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.course.OrgCourseClassTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgCourseClassTypeService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgCourseClassTypeServiceImpl extends AbstractBaseService<OrgCourseClassType,Integer> implements OrgCourseClassTypeService {
    @Autowired
    OrgCourseClassTypeDao orgCourseClassTypeDao;
    

    @Override
    protected IBaseDao<OrgCourseClassType,Integer> getBaseDao() {
        return orgCourseClassTypeDao;
    }
}
