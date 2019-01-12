package com.alonelaval.cornerstone.servce.impl.org.employee;

import com.google.common.collect.Lists;
import com.alonelaval.cornerstone.cache.CourseCategoryCache;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeSkillDao;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeSkill;
import com.alonelaval.cornerstone.entity.biz.PlatformCourseCategory;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeSkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;



/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgEmployeeSkillService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgEmployeeSkillServiceImpl extends AbstractBaseService<OrgEmployeeSkill,Integer>  implements OrgEmployeeSkillService {
    @Autowired
    OrgEmployeeSkillDao orgEmployeeSkillDao;
    

    @Override
    protected IBaseDao<OrgEmployeeSkill,Integer> getBaseDao() {
        return orgEmployeeSkillDao;
    }

    @Override
    public List<OrgEmployeeSkill> addSkill(List<Integer> categoryIds, OrgEmployee orgEmployee) throws Exception {
        if(categoryIds != null && !categoryIds.isEmpty()){
            List<OrgEmployeeSkill> orgEmployeeSkills = Lists.newArrayList();
            OrgEmployeeSkill skill =null;
            for(Integer categoryId : categoryIds) {
                // TODO: 2018/8/11 可以用缓存
                PlatformCourseCategory courseCategory = CourseCategoryCache.getInstance().get(categoryId);
                if(courseCategory != null){
                     skill = OrgEmployeeSkill.builder()
                            .employeId(orgEmployee.getEmployeId())
                            .firstCategoryId(courseCategory.getParentCategoryId())
                            .firstCategoryName(CourseCategoryCache.getInstance().get(courseCategory.getParentCategoryId())
                                    .getCategoryName())
                            .secondCategoryId(courseCategory.getCategoryId())
                            .secondCategoryName(courseCategory.getCategoryName())
                            .orgId(orgEmployee.getOrgId())
                            .orgName(orgEmployee.getOrgName())
                            .userId(orgEmployee.getUserId())
                            .userName(orgEmployee.getUserName())
                            .build();

                    SetEntityProperties.getInstance().setProperties(skill);

                    orgEmployeeSkills.add(add(skill));
                }
            }
            return orgEmployeeSkills;
        }
        return Collections.EMPTY_LIST;
    }
}
