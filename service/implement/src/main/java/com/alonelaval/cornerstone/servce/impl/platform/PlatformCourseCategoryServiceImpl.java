package com.alonelaval.cornerstone.servce.impl.platform;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.platform.PlatformCourseCategoryDao;
import com.alonelaval.cornerstone.entity.biz.PlatformCourseCategory;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.platform.PlatformCourseCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("platformCourseCategoryService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class PlatformCourseCategoryServiceImpl extends AbstractBaseService<PlatformCourseCategory,Integer> implements PlatformCourseCategoryService {
    @Autowired
    PlatformCourseCategoryDao platformCourseCategoryDao;
    

    @Override
    protected IBaseDao<PlatformCourseCategory,Integer> getBaseDao() {
        return platformCourseCategoryDao;
    }
}
