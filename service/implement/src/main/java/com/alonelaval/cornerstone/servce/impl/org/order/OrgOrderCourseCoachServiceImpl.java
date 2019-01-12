package com.alonelaval.cornerstone.servce.impl.org.order;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgOrderCourseCoachDao;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.biz.OrgOrderCourse;
import com.alonelaval.cornerstone.entity.biz.OrgOrderCourseCoach;
import com.alonelaval.cornerstone.entity.biz.User;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.order.OrgOrderCourseCoachService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgOrderCourseCoachService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgOrderCourseCoachServiceImpl extends AbstractBaseService<OrgOrderCourseCoach,Integer> implements OrgOrderCourseCoachService {
    @Autowired
    OrgOrderCourseCoachDao orgOrderCourseCoachDao;
    

    @Override
    protected IBaseDao<OrgOrderCourseCoach,Integer> getBaseDao() {
        return orgOrderCourseCoachDao;
    }

    @Override
    public OrgOrderCourseCoach addOrderCoach(OrgOrderCourse orgOrderCourse, OrgEmployee orgEmployee,User user) throws Exception {
        OrgOrderCourseCoach courseCoach = OrgOrderCourseCoach.builder()
                .courseId(orgOrderCourse.getCourseId())
                .courseName(orgOrderCourse.getCourseName())
                .orgId(orgOrderCourse.getOrgId())
                .orgName(orgOrderCourse.getOrgName())
                .orgOrderId(orgOrderCourse.getOrgOrderId())
                .dealNumber(orgOrderCourse.getDealNumber())
                .userId(user.getUserId())
                .userName(user.getUserRealName())
                .coachUserId(orgEmployee.getUserId())
                .coachUserName(orgEmployee.getUserName())
                .employeId(orgEmployee.getEmployeId())
                .build();
        SetEntityProperties.getInstance().setProperties(courseCoach);
        return  add(courseCoach);

    }
}
