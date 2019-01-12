package com.alonelaval.cornerstone.servce.impl.user;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.util.AssertUtil;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.UserAttendClassRecordDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.OrgClass;
import com.alonelaval.cornerstone.entity.biz.QUserAttendClassRecord;
import com.alonelaval.cornerstone.entity.biz.UserAttendClassRecord;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.UserAttendClassRecordModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.classes.OrgClassService;
import com.alonelaval.cornerstone.service.user.UserAttendClassRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("userAttendClassRecordService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UserAttendClassRecordServiceImpl extends AbstractBaseService<UserAttendClassRecord,Integer> implements UserAttendClassRecordService {
    @Autowired
    UserAttendClassRecordDao userAttendClassRecordDao;
    @Autowired
    OrgClassService orgClassService;


    @Override
    public UserAttendClassRecord add(Model model) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        UserAttendClassRecordModel userAttendClassRecordModel = (UserAttendClassRecordModel) model;
        if(!userAttendClassRecordModel.getUserId().equals(userAdapter.getUser().getUserId())){
            AssertUtil.isTrue(true,ExceptionType.PARAM_ERROR);
        }
        Optional<OrgClass> optionalOrgClass = orgClassService.findById(userAttendClassRecordModel.getClassId());


        if(!optionalOrgClass.isPresent() || !optionalOrgClass.get().getCourseId().equals(userAttendClassRecordModel.getCourseId())
                ){
            // TODO: 2018/9/6 是否教练也要确实是对的教练
            // || !optionalOrgClass.get().getMainCoachEmployeId().equals(userAttendClassRecordModel.getMainCoachEmployeId())
            AssertUtil.isTrue(true,ExceptionType.PARAM_ERROR);
        }

        Optional<UserAttendClassRecord> userAttendClassRecordOptional = findUserCheckin(userAdapter.getUser().getUserId(),
                optionalOrgClass.get().getCourseId(),optionalOrgClass.get().getClassId());
        //已签到
        if(userAttendClassRecordOptional.isPresent()){
            userAttendClassRecordOptional.get().setEndTime(LocalDateTime.now());
            return  this.update(userAttendClassRecordOptional.get());
        }else {
            UserAttendClassRecord userAttendClassRecord =UserAttendClassRecord.builder()
                    .beginTime(LocalDateTime.now())
                    .endTime(LocalDateTime.now())
                    .courseId(optionalOrgClass.get().getCourseId())
                    .courseName(optionalOrgClass.get().getCourseName())
                    .classId(optionalOrgClass.get().getClassId())
                    .className(optionalOrgClass.get().getClassName())
                    .orgId(optionalOrgClass.get().getOrgId())
                    .orgName(optionalOrgClass.get().getOrgName())
                    .secondCategoryId(optionalOrgClass.get().getSecondCategoryId())
                    .secondCategoryName(optionalOrgClass.get().getSecondCategoryName())
                    .userId(userAdapter.getUser().getUserId())
                    .userName(userAdapter.getUser().getUserRealName())
                    .checkinType(userAttendClassRecordModel.getCheckinType())
                    .mainCoachEmployeId(optionalOrgClass.get().getMainCoachEmployeId())
                    .manCoachUserId(optionalOrgClass.get().getMainCoachUserId())
                    .manCoachUserName(optionalOrgClass.get().getMainCoachUserName())
                    .build();


            SetEntityProperties.getInstance().setProperties(userAttendClassRecord);

            return  this.add(userAttendClassRecord);
        }
    }



    private Optional<UserAttendClassRecord> findUserCheckin(Integer userId, Integer courseId, Integer classId) throws Exception {
        AssertUtil.isTrue(classId == null,ExceptionType.PARAM_ERROR);
        AssertUtil.isTrue(courseId == null,ExceptionType.PARAM_ERROR);

        return  userAttendClassRecordDao.findOne(WhereBuilder.build()
                .and(QUserAttendClassRecord.userAttendClassRecord.userId,userId)
                .and(QUserAttendClassRecord.userAttendClassRecord.courseId,courseId)
                .and(QUserAttendClassRecord.userAttendClassRecord.classId,classId)
                .andLocalDateTimeEquals(QUserAttendClassRecord.userAttendClassRecord.createTime,LocalDateTime.now())
                .predicate());

    }

    @Override
    protected IBaseDao<UserAttendClassRecord,Integer> getBaseDao() {
        return userAttendClassRecordDao;
    }
}
