package com.alonelaval.cornerstone.dao.impl.platform;

import com.alonelaval.cornerstone.dao.inter.platform.PlatformCourseCategoryDao;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.PlatformCourseCategoryRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.platform.PlatformCourseCategoryDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.PlatformCourseCategoryRepository;
import com.alonelaval.cornerstone.entity.biz.PlatformCourseCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="platformCourseCategoryDao")
public class PlatformCourseCategoryDaoImpl  extends AbstractBaseDao<PlatformCourseCategory,Integer> implements PlatformCourseCategoryDao {

    @Autowired
    PlatformCourseCategoryRepository platformCourseCategoryRepository;

    @Override
    protected BaseRepository<PlatformCourseCategory, Integer> getBaseRepository() {
        return platformCourseCategoryRepository;
    }
}
