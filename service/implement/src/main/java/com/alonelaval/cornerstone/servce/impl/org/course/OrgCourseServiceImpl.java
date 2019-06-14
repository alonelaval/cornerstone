package com.alonelaval.cornerstone.servce.impl.org.course;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.cornerstone.cache.CourseCategoryCache;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgCourseDao;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.*;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.OrgCourseModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.OrgService;
import com.alonelaval.cornerstone.service.org.course.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgCourseService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgCourseServiceImpl extends AbstractBaseService<OrgCourse,Integer>  implements OrgCourseService {
    @Autowired
    OrgCourseDao orgCourseDao;
    @Autowired
    OrgService orgService;
    @Autowired
    OrgCourseClassTypeService orgCourseClassTypeService;
    @Autowired
    OrgCoursePeriodService orgCoursePeriodService;
    @Autowired
    OrgCoursePriceService orgCoursePriceService;
    @Autowired
    OrgCourseResourceService orgCourseResourceService;
    @Autowired
    OrgCoursePlaceService orgCoursePlaceService;


    @Override
    public OrgCourse findOneByNameAndOrgId(String courseName, Integer orgId) throws Exception {
        return orgCourseDao.findOneByNameAndOrgId(courseName,orgId);
    }

    @Override
    public OrgCourse add(Model model) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        OrgCourseModel orgCourseModel = (OrgCourseModel) model;

        if(!userAdapter.getOrg().isPresent() || !userAdapter.getOrg().get().getOrgId().equals(orgCourseModel.getOrgId())){
            throw  new ServiceException(ExceptionType.NOT_AUTH.value(),ExceptionType.NOT_AUTH.desc());
        }
        Optional<Org> optionalOrg = orgService.findById(orgCourseModel.getOrgId());

        if(!optionalOrg.isPresent()){
            throw  new ServiceException(ExceptionType.ORG_NOT_FOUND.value(),ExceptionType.ORG_NOT_FOUND.desc());
        }
        Optional<OrgCourseClassType> orgCourseClassType = orgCourseClassTypeService.findById(orgCourseModel.getCctId());
        if(!orgCourseClassType.isPresent() || findOneByNameAndOrgId(orgCourseModel.getCourseName(),optionalOrg.get()
                .getOrgId()) != null){
            throw  new ServiceException(ExceptionType.PARAM_ERROR.value(),"课程名称已存在！");
        }

        PlatformCourseCategory courseCategory = CourseCategoryCache.getInstance().get(orgCourseModel.getSecondCategoryId());
        OrgCourse orgCourse = OrgCourse.builder()
                .cctId(orgCourseModel.getCctId())
                .orgId(orgCourseModel.getOrgId())
                .orgName(optionalOrg.get().getOrgName())
                .classTypeName(orgCourseClassType.get().getClassTypeName())
                .courseName(orgCourseModel.getCourseName())
                .isSettingTime(orgCourseModel.getIsSettingTime())
                .remark(orgCourseModel.getRemark())
                .startType(orgCourseModel.getStartType())
                .secondCategoryId(courseCategory.getCategoryId())
                .secondCategoryName(courseCategory.getCategoryName())
                .firstCategoryId(courseCategory.getParentCategoryId())
                .firstCategoryName(CourseCategoryCache.getInstance().get(orgCourseModel.getSecondCategoryId())
                        .getCategoryName())
                //如果没有在表单设置开班人数，取默认设置的人数
                .startUserNum(orgCourseModel.getStartUserNum() == null ? orgCourseClassType.get().getStartUserNum():
                        orgCourseModel.getStartUserNum())
                .courseType(orgCourseModel.getCourseType())
                .build();

        SetEntityProperties.getInstance().setProperties(orgCourse);

        orgCourse = add(orgCourse);
        //添加上课周期
        orgCoursePeriodService.addCoursePeriod(orgCourseModel.getPeriodModels(),orgCourse);
        //添加价格
        orgCoursePriceService.addCoursePrice(orgCourseModel.getPriceModels(),orgCourse);
        //添加资源
        orgCourseResourceService.addResource(orgCourseModel.getResourceFileNames(),orgCourse);
        //添加地点
        orgCoursePlaceService.addPlace(orgCourseModel.getPlaceIds(),orgCourse);


        return orgCourse;
    }

    @Override
    protected IBaseDao<OrgCourse,Integer> getBaseDao() {
        return orgCourseDao;
    }
}
