package com.alonelaval.cornerstone.servce.impl.user;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.message.SmsCodeGenerator;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.UserStudentDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.QUserStudent;
import com.alonelaval.cornerstone.entity.biz.User;
import com.alonelaval.cornerstone.entity.biz.UserStudent;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.UserModel;
import com.alonelaval.cornerstone.entity.model.UserStudentModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.user.UserService;
import com.alonelaval.cornerstone.service.user.UserStudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("userStudentService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UserStudentServiceImpl extends AbstractBaseService<UserStudent,Integer> implements UserStudentService {
    @Autowired
    UserStudentDao userStudentDao;
    @Autowired
    UserService userService;


    @Override
    public Page<UserStudent> findByModelAndPage(Model model, Page<UserStudent> page) throws Exception {

        UserStudentModel userStudentModel = (UserStudentModel) model;
        WhereBuilder builder = WhereBuilder.build();


        if(userStudentModel.getState() == null ){
            builder.in(QUserStudent.userStudent.state,State.ENABLED,State.DISABLED);
        }else
        {
            builder.and(QUserStudent.userStudent.state.eq(userStudentModel.getState()));
        }


        builder.startWith(QUserStudent.userStudent.studentUserName,userStudentModel.getStudentUserName());
        builder.startWith(QUserStudent.userStudent.guardianUserName,userStudentModel.getGuardianUserName());
        builder.startWith(QUserStudent.userStudent.phone,userStudentModel.getPhone());
        builder.and(QUserStudent.userStudent.guardianUserId,userStudentModel.getGuardianUserId());

        return userStudentDao.findAllByPredicateAndPage(builder.predicate(),page);
    }

    @Override
    public UserStudent add(Model model) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        UserStudentModel studentModel = (UserStudentModel) model;
        // TODO: 2018/8/13  如果小孩有手机号，跟他也注册一个账号，迁到时可以直接用自己的手机号进行登录
        User user = null;
        if(StringUtils.isNotBlank(studentModel.getPhone())) {
            user= userService.userRegister(UserModel.builder()
                    .userName(studentModel.getStudentUserName())
                    .birthDay(studentModel.getBirthday())
                    .phoneCode(studentModel.getPhoneCode())
                    .phone(studentModel.getPhone())
                    .loginPassword(SmsCodeGenerator.generateCode())
                    .gender(studentModel.getGender())
                    .build());
        }

        UserStudent student = UserStudent.builder()
                .birthday(studentModel.getBirthday())
                .phone(studentModel.getPhone())
                .gender(studentModel.getGender())
                .relationType(studentModel.getRelationType())
                .studentUserName(studentModel.getStudentUserName())
                .studentUserId(user == null ?null:user.getUserId())
                .guardianUserId(userAdapter.getUser().getUserId())
                .guardianUserName(userAdapter.getUser().getUserRealName())
                .build();

        SetEntityProperties.getInstance().setProperties(student);

        return add(student);
    }


    @Override
    protected IBaseDao<UserStudent,Integer> getBaseDao() {
        return userStudentDao;
    }
}
