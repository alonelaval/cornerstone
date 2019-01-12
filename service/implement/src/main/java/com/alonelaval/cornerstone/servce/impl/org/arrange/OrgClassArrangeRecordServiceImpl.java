package com.alonelaval.cornerstone.servce.impl.org.arrange;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.exception.ExceptionUtil;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgClassArrangeRecordDao;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.*;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.ClassArrangeType;
import com.alonelaval.cornerstone.entity.constants.ClassState;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.OrgClassArrangeRecordModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.arrange.OrgClassArrangeRecordService;
import com.alonelaval.cornerstone.service.org.classes.OrgClassCoachService;
import com.alonelaval.cornerstone.service.org.classes.OrgClassService;
import com.alonelaval.cornerstone.service.org.classes.OrgClassStudentService;
import com.alonelaval.cornerstone.service.org.course.OrgCoursePeriodService;
import com.alonelaval.cornerstone.service.org.course.OrgCoursePlaceService;
import com.alonelaval.cornerstone.service.org.course.OrgCourseService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeService;
import com.alonelaval.cornerstone.service.org.order.OrgOrderCourseService;
import com.alonelaval.cornerstone.service.org.student.OrgStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgClassArrangeRecordService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgClassArrangeRecordServiceImpl extends AbstractBaseService<OrgClassArrangeRecord,Integer>  implements OrgClassArrangeRecordService {
    @Autowired
    OrgClassArrangeRecordDao orgCourseArrangeDao;
    @Autowired
    OrgCourseService orgCourseService;
    @Autowired
    OrgCoursePeriodService orgCoursePeriodService;
    @Autowired
    OrgCoursePlaceService orgCoursePlaceService;
    @Autowired
    OrgEmployeeService orgEmployeeService;
    @Autowired
    OrgOrderCourseService orderCourseService;
    @Autowired
    OrgStudentService orgStudentService;
    @Autowired
    OrgClassService orgClassService;
    @Autowired
    OrgClassCoachService orgClassCoachService;
    @Autowired
    OrgClassStudentService orgClassStudentService;

    @Override
    public OrgClassArrangeRecord add(Model model) throws Exception {
        OrgClassArrangeRecordModel arrangeModel = (OrgClassArrangeRecordModel) model;
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();

        if(userAdapter.getLoginType().equals(RoleOwnType.ORG_ROLE)){
            Optional<OrgCourse> orgCourse = orgCourseService.findById(arrangeModel.getCourseId());
            if(orgCourse.isPresent() && orgCourse.get().getOrgId().equals(userAdapter.getOrg().get().getOrgId())){
                //上课的时间
                Optional<OrgCoursePeriod> period = orgCoursePeriodService.findById(arrangeModel.getCoursePeriodId());

                //上课地点
                Optional<OrgCoursePlace> place = orgCoursePlaceService.findById(arrangeModel.getCoursePlaceId());

                //如果不选择直接异常
                if(!period.isPresent() || !place.isPresent()){
                    ExceptionUtil.throwServiceException(ExceptionType.PARAM_ERROR);
                }

                //所有选择的教练
                List<OrgEmployee> orgEmployees  = orgEmployeeService.findAllCoachByEmployeIds(arrangeModel.getEmployeIds());
                //从前端传过来的上课人，已经经过过滤了，确定传过来的用户，在这个时间点，是需要排课的
                List<OrgStudent> orgStudents = orgStudentService.findAllByIds(arrangeModel.getOrgStudentIds());
                //默认第一个选的就是主教练
                OrgEmployee mainCoach = orgEmployees.get(0);

                OrgClass orgClass = OrgClass.builder()
                        .beginTime(period.get().getBeginTime())
                        .endTime(period.get().getEndTime())
                        .beginDate(orgCourse.get().getBeginDate())
                        .endDate(orgCourse.get().getEndDate())
                        .courseId(orgCourse.get().getCourseId())
                        .courseName(orgCourse.get().getCourseName())
                        .className(arrangeModel.getClassName())
                        .mainCoachUserId(mainCoach.getUserId())
                        .mainCoachEmployeId(mainCoach.getEmployeId())
                        .mainCoachUserName(mainCoach.getUserName())
                        .courseType(orgCourse.get().getCourseType())
                        .gradeType(arrangeModel.getGradeType())
                        .cctId(orgCourse.get().getCctId())
                        .classTypeName(orgCourse.get().getClassTypeName())
                        .firstCategoryId(orgCourse.get().getFirstCategoryId())
                        .firstCategoryName(orgCourse.get().getFirstCategoryName())
                        .secondCategoryId(orgCourse.get().getSecondCategoryId())
                        .secondCategoryName(orgCourse.get().getSecondCategoryName())
                        .checkinExponent(0)
                        .joinUserNum(orgStudents.size())
                        .startUserNum(orgCourse.get().getStartUserNum())
                        .placeId(place.get().getPlaceId())
                        .placeName(place.get().getPlaceName())
                        .arrangeType(ClassArrangeType.MANUAL)
                        .state(ClassState.PREPARE)
                        .lastUpdateTime(LocalDateTime.now())
                        .createTime(LocalDateTime.now())
                        .orgId(orgCourse.get().getOrgId())
                        .orgName(orgCourse.get().getOrgName())
                        .build();


                orgClass = orgClassService.addOrgClass(orgClass);
                OrgClassArrangeRecord record = addRecord(orgClass,userAdapter.getOrgEmployee());
                orgClassCoachService.addClassCoachs(orgEmployees,orgClass);
                orgClassStudentService.addOrgClassStudents(orgStudents,orgClass);

                return  record;
            }
        }

        ExceptionUtil.throwServiceException(ExceptionType.NOT_AUTH);
        return null;

    }



    private OrgClassArrangeRecord addRecord(OrgClass orgClass,OrgEmployee orgEmployee) throws Exception {
        OrgClassArrangeRecord orgClassArrangeRecord = OrgClassArrangeRecord.builder()
                .classId(orgClass.getClassId())
                .className(orgClass.getClassName())
                .courseId(orgClass.getCourseId())
                .courseName(orgClass.getCourseName())
                .orgId(orgEmployee.getOrgId())
                .orgName(orgEmployee.getOrgName())
                .userId(orgEmployee.getUserId())
                .userName(orgEmployee.getUserName())
                .employeId(orgEmployee.getEmployeId())
                .arrangeType(ClassArrangeType.MANUAL)
                .build();
        SetEntityProperties.getInstance().setProperties(orgClassArrangeRecord);


        return this.add(orgClassArrangeRecord);
    }




    @Override
    protected IBaseDao<OrgClassArrangeRecord,Integer> getBaseDao() {
        return orgCourseArrangeDao;
    }
}
