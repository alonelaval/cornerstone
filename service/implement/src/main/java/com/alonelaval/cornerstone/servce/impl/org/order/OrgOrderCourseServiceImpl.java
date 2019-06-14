package com.alonelaval.cornerstone.servce.impl.org.order;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgOrderCourseDao;
import com.alonelaval.cornerstone.entity.biz.*;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.IsArrangeClass;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.order.OrgOrderCoursePeriodService;
import com.alonelaval.cornerstone.service.org.order.OrgOrderCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgOrderCourseService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgOrderCourseServiceImpl extends AbstractBaseService<OrgOrderCourse,Integer> implements OrgOrderCourseService {
    @Autowired
    OrgOrderCourseDao orgOrderCourseDao;
    @Autowired
    OrgOrderCoursePeriodService orgOrderCoursePeriodService;
    

    @Override
    protected IBaseDao<OrgOrderCourse,Integer> getBaseDao() {
        return orgOrderCourseDao;
    }

    @Override
    public OrgOrderCourse addOrderCourse(OrgCourse orgCourse, OrgOrder orgOrder, OrgStudent orgStudent, User user,
                                         OrgCoursePrice coursePrice, OrgCoursePlace orgCoursePlace) throws Exception {
        OrgOrderCourse orderCourse = OrgOrderCourse.builder()
                .courseId(orgCourse.getCourseId())
                .courseName(orgCourse.getCourseName())
                .courseType(orgCourse.getCourseType())
                .orgId(orgCourse.getOrgId())
                .orgName(orgCourse.getOrgName())
                .orgOrderId(orgOrder.getOrgOrderId())
                .dealNumber(orgOrder.getDealNumber())
                .orgStudentId(orgStudent.getOrgStudentId())
                .userStudentId(orgStudent.getUserStudentId())
                .attendUserId(orgStudent.getStudentUserId())
                .attendUserName(orgStudent.getStudentUserName())
                .userId(user.getUserId())
                .userName(user.getUserRealName())
                .buyCourseCount(coursePrice.getCourseCount())
                .buyCourseTime(coursePrice.getTotalCourseTime())
                .oneCourseTime(coursePrice.getCourseTime())
                .totalAmount(coursePrice.getPrice())
                .placeId(orgCoursePlace.getPlaceId())
                .placeName(orgCoursePlace.getPlaceName())
                .isArrangeClass(IsArrangeClass.FALSE)
                .build();

        SetEntityProperties.getInstance().setProperties(orderCourse);

        return  this.add(orderCourse);
    }

    @Override
    public List<OrgOrderCourse> findNotArrangeOrderCourse(Integer courseId) throws Exception {
        return  orgOrderCourseDao.findAllByCourseIdAndIsArrangeClass(courseId,IsArrangeClass.FALSE);
    }

    @Override
    public List<OrgOrderCourse> findNotArrangeOrderCourseAndPeriod(Integer courseId, Integer cpId) throws Exception {

        List<OrgOrderCourse> orgOrderCourses = this.findNotArrangeOrderCourse(courseId);
        if(orgOrderCourses != null && !orgOrderCourses.isEmpty()){
            List<Integer> userIds = orgOrderCourses.stream().mapToInt(OrgOrderCourse::getUserId).boxed().collect(Collectors.toList());

            List<OrgOrderCoursePeriod> periods = orgOrderCoursePeriodService.findAllByCourseIdAndCpIdAndUserIdIn(courseId,cpId,userIds);

            //该时间点没有上课的用户
            if(periods == null || periods.isEmpty() )
            {
                return Collections.emptyList();
            }
            List<Integer> periodUserIds = periods.stream().mapToInt(OrgOrderCoursePeriod::getUserId).boxed().collect(Collectors.toList());

            //并集，如果在里面，返回给前端选择
            userIds.retainAll(periods);

            return  orgOrderCourses.stream().filter(o->userIds.contains(o.getUserId())).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
