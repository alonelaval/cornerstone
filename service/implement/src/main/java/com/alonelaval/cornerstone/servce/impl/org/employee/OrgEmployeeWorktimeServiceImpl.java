package com.alonelaval.cornerstone.servce.impl.org.employee;

import com.google.common.collect.Lists;
import com.alonelaval.cornerstone.cache.CourseCategoryCache;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeWorktimeDao;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeWorkday;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeWorktime;
import com.alonelaval.cornerstone.entity.biz.PlatformCourseCategory;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.model.OrgEmployeeWorktimeModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeWorktimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgEmployeeWorktimeService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgEmployeeWorktimeServiceImpl extends AbstractBaseService<OrgEmployeeWorktime,Integer>  implements OrgEmployeeWorktimeService {
    @Autowired
    OrgEmployeeWorktimeDao orgEmployeeWorktimeDao;
    

    @Override
    protected IBaseDao<OrgEmployeeWorktime,Integer> getBaseDao() {
        return orgEmployeeWorktimeDao;
    }

    @Override
    public List<OrgEmployeeWorktime> addWorkTime(List<OrgEmployeeWorktimeModel> models, OrgEmployeeWorkday workday) throws Exception {
        List<OrgEmployeeWorktime> orgEmployeeWorktimes = Lists.newArrayList();
        if(models != null && !models.isEmpty()) {
            OrgEmployeeWorktime orgEmployeeWorktime= null;
            for (OrgEmployeeWorktimeModel model : models) {
                PlatformCourseCategory courseCategory = CourseCategoryCache.getInstance().get(model.getSecondCategoryId());
                PlatformCourseCategory firstCourseCategory = CourseCategoryCache.getInstance().get(courseCategory.getParentCategoryId());

                 orgEmployeeWorktime=OrgEmployeeWorktime.builder()
                        .orgId(workday.getOrgId())
                        .orgName(workday.getOrgName())
                        .userId(workday.getUserId())
                        .userName(workday.getUserName())
                        .employeId(workday.getEmployeId())
                        .dayType(model.getDayType())
                        .beginTime(model.getBeginTime())
                        .endTime(model.getEndTime())
                        .firstCategoryId(firstCourseCategory.getCategoryId())
                        .firstCategoryName(firstCourseCategory.getCategoryName())
                        .secondCategoryId(courseCategory.getCategoryId())
                        .secondCategoryName(courseCategory.getCategoryName())
                        .workdayId(workday.getWorkdayId())
                        .build();
                SetEntityProperties.getInstance().setProperties(orgEmployeeWorktime);

                orgEmployeeWorktimes.add(this.add(orgEmployeeWorktime));
            }
        }
        return orgEmployeeWorktimes;
    }
}
