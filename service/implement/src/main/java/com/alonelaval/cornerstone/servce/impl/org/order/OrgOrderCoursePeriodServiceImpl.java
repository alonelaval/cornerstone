package com.alonelaval.cornerstone.servce.impl.org.order;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.google.common.collect.Lists;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgOrderCoursePeriodDao;
import com.alonelaval.cornerstone.entity.biz.OrgCoursePeriod;
import com.alonelaval.cornerstone.entity.biz.OrgOrderCourse;
import com.alonelaval.cornerstone.entity.biz.OrgOrderCoursePeriod;
import com.alonelaval.cornerstone.entity.biz.User;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.course.OrgCoursePeriodService;
import com.alonelaval.cornerstone.service.org.order.OrgOrderCoursePeriodService;
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
@Service("orgOrderCoursePeriodService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgOrderCoursePeriodServiceImpl extends AbstractBaseService<OrgOrderCoursePeriod,Integer> implements OrgOrderCoursePeriodService {
    @Autowired
    OrgOrderCoursePeriodDao orgOrderCoursePeriodDao;
    @Autowired
    OrgCoursePeriodService orgCoursePeriodService;

    @Override
    protected IBaseDao<OrgOrderCoursePeriod,Integer> getBaseDao() {
        return orgOrderCoursePeriodDao;
    }

    @Override
    public List<OrgOrderCoursePeriod> addCoursePeriod(List<Integer> coursePeriodIds, OrgOrderCourse orgOrderCourse, User user)
            throws Exception {
        if(coursePeriodIds != null ) {
            List<OrgCoursePeriod> periods = orgCoursePeriodService.findAllByIds(coursePeriodIds);
            return  addPeriods(periods,orgOrderCourse,user);
        }
        return Collections.emptyList();
    }



    @Override
    public List<OrgOrderCoursePeriod> addCoursePeriod(OrgOrderCourse orgOrderCourse, User user) throws Exception {
        List<OrgCoursePeriod> periods = orgCoursePeriodService.findPeriodsByCourseId(orgOrderCourse.getCourseId());
        return addPeriods(periods,orgOrderCourse,user);
    }

    @Override
    public List<OrgOrderCoursePeriod> findAllByCourseIdAndCpIdAndUserIdIn(Integer courseId, Integer cpId, List<Integer> userIds) throws Exception {
        return orgOrderCoursePeriodDao.findAllByCourseIdAndCpIdAndUserIdIn( courseId,  cpId, userIds);
    }


    private List<OrgOrderCoursePeriod> addPeriods(List<OrgCoursePeriod> periods,OrgOrderCourse orgOrderCourse, User user) throws Exception {
        List<OrgOrderCoursePeriod> periodList = Lists.newArrayList();
        for (OrgCoursePeriod period: periods){

            OrgOrderCoursePeriod coursePeriod = OrgOrderCoursePeriod.builder()
                    .courseId(orgOrderCourse.getCourseId())
                    .courseName(orgOrderCourse.getCourseName())
                    .orgId(orgOrderCourse.getOrgId())
                    .orgName(orgOrderCourse.getOrgName())
                    .orgOrderId(orgOrderCourse.getOrgOrderId())
                    .dealNumber(orgOrderCourse.getDealNumber())
                    .userId(user.getUserId())
                    .userName(user.getUserRealName())
                    .timeType(period.getTimeType())
                    .beginTime(period.getBeginTime())
                    .endTime(period.getEndTime())
                    .dayType(period.getDayType())
                    .cpId(period.getCpId())
                    .build();

            SetEntityProperties.getInstance().setProperties(coursePeriod);
            periodList.add(this.add(coursePeriod));
        }
        return periodList;
    }

}
