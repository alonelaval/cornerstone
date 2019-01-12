package com.alonelaval.cornerstone.cache;

import com.alonelaval.cornerstone.cache.config.CacheApplicationContextRegister;
import com.alonelaval.cornerstone.entity.biz.PlatformCourseCategory;
import com.alonelaval.cornerstone.service.platform.PlatformCourseCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import java.util.Optional;

//import org.ehcache.config.builders.CacheConfigurationBuilder;
//import org.ehcache.config.builders.ResourcePoolsBuilder;

/**
 * @author huawei
 * @create 2018-08-11
 **/
@Slf4j
public class CourseCategoryCache {

    private PlatformCourseCategoryService platformCourseCategoryService;
    private CacheManager cacheManager;
    private Cache<Integer, PlatformCourseCategory> courseCategoryCache;

    private CourseCategoryCache(){

        platformCourseCategoryService = (PlatformCourseCategoryService) CacheApplicationContextRegister.getApplicationContext().getBean("platformCourseCategoryService");
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        cacheManager.init();
        courseCategoryCache = cacheManager.createCache("courseCategory",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Integer.class, PlatformCourseCategory.class,
                        ResourcePoolsBuilder.heap(1000)));

        load();
    }

    public PlatformCourseCategory get(Integer key){
        return  courseCategoryCache.get(key);
    }

    public void load(){
        try {
            Iterable<PlatformCourseCategory> platformCourseCategories = platformCourseCategoryService.listAll(null);
            if(Optional.ofNullable(platformCourseCategories).isPresent()){
                platformCourseCategories.forEach(platformCourseCategory -> courseCategoryCache.put(
                        platformCourseCategory.getCategoryId(),platformCourseCategory
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void close(){
        courseCategoryCache.clear();
        cacheManager.removeCache("preConfigured");
        cacheManager.close();
    }
    public static CourseCategoryCache getInstance() {
        return CourseCategoryCacheHolder.instance;
    }

    private static class CourseCategoryCacheHolder{
        private static CourseCategoryCache instance = new CourseCategoryCache();
    }
}
