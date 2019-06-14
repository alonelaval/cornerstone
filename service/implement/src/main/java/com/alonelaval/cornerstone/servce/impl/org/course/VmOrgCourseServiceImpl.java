package com.alonelaval.cornerstone.servce.impl.org.course;


import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.google.common.collect.Lists;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.VmOrgCourseDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.biz.*;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.VmOrgCourseModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.course.OrgCoursePeriodService;
import com.alonelaval.cornerstone.service.org.course.VmOrgCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("vmOrgCourseService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class VmOrgCourseServiceImpl extends AbstractBaseService<VmOrgCourse,Integer> implements VmOrgCourseService {
    @Autowired
    VmOrgCourseDao vmOrgCourseDao;
    @Autowired
    OrgCoursePeriodService orgCoursePeriodService;


  	@Override
    public Page<VmOrgCourse> findByModelAndPage(Model model, Page page) throws Exception {
        VmOrgCourseModel vmOrgCourseModel = (VmOrgCourseModel) model;
        WhereBuilder builder = WhereBuilder.build();


        if(vmOrgCourseModel.getState() == null ){
            builder.in(QVmOrgCourse.vmOrgCourse.state,State.ENABLED,State.DISABLED);
        }else
        {
            builder.and(QVmOrgCourse.vmOrgCourse.state.eq(vmOrgCourseModel.getState()));
        }
        builder.and(QVmOrgCoach.vmOrgCoach.secondCategoryId,vmOrgCourseModel.getSecondCategoryId());
        builder.startWith(QVmOrgCourse.vmOrgCourse.courseName,vmOrgCourseModel.getCourseName());
        builder.andBetweenDate(QVmOrgCourse.vmOrgCourse.beginDate,vmOrgCourseModel.getBeginDate()
                ,vmOrgCourseModel.getEndDate());

        page = vmOrgCourseDao.findAllByPredicateAndPage(builder.predicate(),page);
        List<VmOrgCourse> courseList = page.getData();

        Map<Integer,List<VmOrgCourse>> courseMap = courseList.stream().collect(groupingBy(VmOrgCourse::getCourseId));

        List<OrgCourse> courses = Lists.newArrayList();

        for(Map.Entry<Integer,List<VmOrgCourse>> entry : courseMap.entrySet()){
            OrgCourse course = OrgCourse.builder().build();
            VmOrgCourse vmOrgCourse = entry.getValue().get(0);
            BeanUtils.copyProperties(vmOrgCourse,course);
            course.setClassTypeCount(entry.getValue().size());
            Integer maxPrice = entry.getValue().stream().max(Comparator.comparing(VmOrgCourse::getPrice)).get().getPrice();
            Integer minPrice = entry.getValue().stream().min(Comparator.comparing(VmOrgCourse::getPrice)).get().getPrice();
            course.setMaxPrice(maxPrice);
            course.setMinPrice(minPrice);

            List<OrgCoursePeriod> periods  = orgCoursePeriodService.findPeriodsByCourseId(entry.getKey());
            course.setPeriods(periods);


            courses.add(course);
        }

        page.setData(courses);

        return page;
    }
    
    @Override
    protected IBaseDao<VmOrgCourse,Integer> getBaseDao() {
        return vmOrgCourseDao;
    }
}
