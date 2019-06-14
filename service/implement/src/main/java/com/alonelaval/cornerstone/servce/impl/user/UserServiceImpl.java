package com.alonelaval.cornerstone.servce.impl.user;

import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.UserDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.*;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.*;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.OrgModel;
import com.alonelaval.cornerstone.entity.model.UserModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.servce.impl.config.ServiceConfig;
import com.alonelaval.cornerstone.service.org.OrgPermissionService;
import com.alonelaval.cornerstone.service.org.OrgService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeService;
import com.alonelaval.cornerstone.service.platform.PlatformShopkeeperService;
import com.alonelaval.cornerstone.service.platform.RolePermissionService;
import com.alonelaval.cornerstone.service.platform.RoleService;
import com.alonelaval.cornerstone.service.platform.SysPermissionService;
import com.alonelaval.cornerstone.service.platform.message.SmsMessageService;
import com.alonelaval.cornerstone.service.user.UserRoleService;
import com.alonelaval.cornerstone.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;


/**
 * @author huawei
 * @create 2018-07-08
 **/
@Service("userService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends AbstractBaseService<User,Integer> implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    OrgService orgService;
    @Autowired
    SmsMessageService smsMessageService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    OrgEmployeeService orgEmployeeService;
    @Autowired
    RoleService roleService;
    @Autowired
    SysPermissionService sysPermissionService;
    @Autowired
    OrgPermissionService orgPermissionService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    RolePermissionService rolePermissionService;
    @Autowired
    PlatformShopkeeperService platformShopkeeperService;
    @Autowired
    ServiceConfig serviceConfig;


    public static final Boolean NEW_USER = Boolean.TRUE;


    @Override
    public boolean usernameIsExist(String username) throws Exception {
        return Optional.ofNullable(userDao.findByLoginName(username)).isPresent();
    }
    @Override
    public boolean phoneIsExist(String phone) throws Exception {
        return  Optional.ofNullable(userDao.findByPhone(phone)).isPresent();
    }
    private boolean checkPassword(String password,String  encodePwd) {
        return  passwordEncoder.matches(password,encodePwd);
    }

    @Override
    public User loginByPhone(String phone, String password) throws Exception {

        User user = userDao.findByPhone(phone);
        if(user == null) {
            return null;
        }

        if(!checkPassword(password,user.getLoginPassword())){
            throw  new UsernameNotFoundException(ExceptionType.RESULT_USER_PASSWORD_NOT_MATCH.desc());
        }

        if(!user.getState().equals(State.ENABLED)){
            throw  new UsernameNotFoundException(ExceptionType.USER_DISABLED_EXCEPTION.desc());
        }
        return  user;
    }

    @Override
    public User findPassword(String loginName, String phone, String newPassword, String phoneCode) throws Exception {
        checkRegCodeExist(phone,phoneCode);
        User user = userDao.findByPhone(phone);
        if(user == null){
            throw  new UsernameNotFoundException(ExceptionType.USER_NOT_FOUND.desc());
        }
        if(!user.getLoginName().equals(loginName)){
            throw  new UsernameNotFoundException(ExceptionType.USER_NOT_FOUND.desc());
        }
        user.setLoginPassword(passwordEncoder.encode(newPassword));

        return this.update(user);
    }


    @Override
    public UserAdapter orgRegister(String orgName, String password, String phone, String phoneCode) throws Exception {
        //验证是否正确
        return  orgRegister(UserModel.builder().phone(phone).loginName(phone)
                        .loginPassword(password).phoneCode(phoneCode).build(),
                OrgModel.builder().orgName(orgName).orgLevel(OrgModel.DEFAULT_ORG_LEVEL).build());
    }

    @Override
    public UserAdapter orgRegister(UserModel userModel, OrgModel orgModel) throws Exception {
        //检查用户手机验证码
        checkRegCodeExist(userModel.getPhone(),userModel.getPhoneCode());
        checkOrgNameExist(orgModel.getOrgName());
        //查找当前用户是否存在
        User user = findByPhone(userModel.getPhone());
        //loginByPhone(userModel.getPhone(),userModel.getLoginPassword());

        boolean isNew =false;
        if(user == null){
            isNew =NEW_USER;
            user = createUser(userModel);
        }
        // TODO: 2018/7/22 添加默认C端角色，但是登录并不使用C端角色
        roleService.createOrFindClientUserRole(user,isNew);

        Org org = orgService.addOrg(orgModel,user);
        //添加机构员工信息
        OrgEmployee orgEmployee = orgEmployeeService.createOrgEmployee(org,user,EmployeeState.ENABLED,
                OrgAccountType.MAIN_ACCOUNT,IsCoach.FALSE);
        //添加店主信息
        PlatformShopkeeper platformShopkeeper = platformShopkeeperService.addShopkeeper(org,user,orgEmployee);
        // TODO: 2018/7/21 测试默认角色，给机构添加角色
        List<Role> defaultRoles = roleService.copyDefaultRolesToOrg(serviceConfig.getOrgDefaultRoleIdList(),org,orgEmployee);

        // TODO: 2018/7/21 默认开通的角色，给用户添加角色
        userRoleService.addOrgUserRole(defaultRoles,org,user);

        // TODO: 2018/7/21 测试  添加默认版本功能
        for(Role role : defaultRoles) {

            List<Integer> permissionIds = rolePermissionService.findAllByRoleIdIn(newArrayList(role.getFromRoleId())).stream()
                    .mapToInt(RolePermission::getPermissionId).boxed().collect(Collectors.toList());

            List<SysPermission> sysPermissions = sysPermissionService.findAllByPermissionIdIn(permissionIds);
            // TODO: 2018/7/21 给机构开通的默认权限
            List<OrgPermission> orgPermissions = orgPermissionService.addOrgPermissionsBySysPermissions(sysPermissions, org);
            // TODO: 2018/7/22 给角色添加默认的权限
            rolePermissionService.addOrgRolePermissions(orgPermissions, role);

            user.setPermissions(orgPermissions);
        }
        user.setRoles(defaultRoles);
        return new UserAdapter(user, org ,orgEmployee,RoleOwnType.ORG_ROLE,platformShopkeeper);
    }


    @Override
    public UserAdapter orgUserRegister(Integer orgId, String password, String phone, String phoneCode) throws Exception {
        checkRegPhoneAndCodeExist(phone,phoneCode);
        User user = createUser(phone,password);

        Optional<Org> optionalOrg =orgService.findById(orgId);
        if(!optionalOrg.isPresent()){
            throw  new ServiceException(ExceptionType.ORG_NOT_FOUND.value(),ExceptionType.ORG_NOT_FOUND.desc());
        }
        Org org = optionalOrg.get();
        // TODO: 2018/7/22 添加默认C端角色
        //添加C端用户权限
        settingUserPermission(user,NEW_USER);

        //新添加用户需机构审核
        OrgEmployee orgEmployee = orgEmployeeService.createOrgEmployee(org,user,EmployeeState.AUDIT,OrgAccountType
                .SUB_ACCOUNT,IsCoach.FALSE);
        return new UserAdapter(user, org ,orgEmployee,RoleOwnType.ORG_ROLE);
    }

    @Override
    public User userRegister(UserModel userModel) throws Exception {
        checkRegCodeExist(userModel.getPhone(),userModel.getPhoneCode());
        User user = userDao.findByPhone(userModel.getPhone());
        boolean isNew =false;
        if(user == null){
            isNew =NEW_USER;
            user = createUser(userModel);
        }
        // TODO: 2018/7/22 添加默认C端角色
        //添加C端用户权限
        settingUserPermission(user,isNew);
        return  user;
    }




    private void settingUserPermission(User user,boolean isNew) throws Exception {
        List<Role> roles = roleService.createOrFindClientUserRole(user,isNew);
        user.setRoles(roles);
        List<Integer> roleIds = roles.stream().mapToInt(Role::getRoleId).boxed().collect(Collectors.toList());
        List<Integer> permissionIds = rolePermissionService.findAllByRoleIdIn(roleIds).stream()
                .mapToInt(RolePermission::getPermissionId).boxed().collect(Collectors.toList());
        user.setPermissions(sysPermissionService.findAllByPermissionIdIn(permissionIds));
    }

    @Override
    public UserAdapter userRegister(String password, String phone, String phoneCode) throws Exception {
        checkRegPhoneAndCodeExist(phone,phoneCode);
        User user = createUser(phone,password);

        // TODO: 2018/7/22 添加默认C端角色
        settingUserPermission(user,NEW_USER);
        return new UserAdapter(user, null ,null,RoleOwnType.USER_ROLE);
    }

    @Override
    public Page<User> findUser(UserModel userModel, Page page) throws Exception {
        User user = User.userBuilder().phone(userModel.getPhone()).build();
        Example<User> example = Example.of(user);
//        Predicate
//        User.userBuilder().build().
//        ExampleMatcher exampleMatcher =  ExampleMatcher.matching().withMatcher("phone",ExampleMatcher.GenericPropertyMatchers.)
        return userDao.findByExampleAndPage(example,page);
    }

    @Override
    public User findByPhone(String phone) throws Exception {
        return userDao.findByPhone(phone);
    }

    @Override
    public Page<User> findByModelAndPage(Model model, Page<User> page) throws Exception {
        UserModel userModel = (UserModel) model;
        WhereBuilder builder = WhereBuilder.build();

        if(userModel.getState() == null ){
            builder.in(QUser.user.state,State.ENABLED,State.DISABLED);
        }else
        {
            builder.and(QUser.user.state.eq(userModel.getState()));
        }
        builder.and(QUser.user.regSource,userModel.getRegSource());
        builder.and(QUser.user.gender,userModel.getGender());
        builder.startWith(QUser.user.userRealName,userModel.getUserName());
        builder.startWith(QUser.user.phone,userModel.getPhone());
        builder.and(QUser.user.gender,userModel.getGender());

        if(userModel.getConsumeCountBegin() != null){
            builder.and(QUser.user.consumeCount.goe(userModel.getConsumeCountBegin()));
        }
        if(userModel.getConsumeCountEnd()!= null){
            builder.and(QUser.user.consumeCount.loe(userModel.getConsumeCountEnd()));
        }


        return userDao.findAllByPredicateAndPage(builder.predicate(),page);
    }

    @Override
    public User createUser(String phone, String password) throws Exception {
        return  createUser(UserModel.builder().phone(phone).loginName(phone).loginPassword(password).build());
    }

    @Override
    public User createUser(UserModel userModel) throws Exception {

        User user = User.userBuilder()
                .loginName(userModel.getLoginName()==null?userModel.getPhone():userModel.getLoginName())
                .phone(userModel.getPhone())
                .email(userModel.getEmail()==null?"":userModel.getEmail())
                .userRealName(userModel.getUserName()==null ?"":userModel.getUserName())
                .gender(userModel.getGender())
                .icon(userModel.getIcon())
                .birthday(userModel.getBirthDay())
                .loginPassword(passwordEncoder.encode(userModel.getLoginPassword())).build();

        SetEntityProperties.getInstance().setProperties(user);
        user = this.addUser(user);
        return  user;
    }


    private void checkOrgNameExist(String orgName) throws Exception {
        if(orgService.orgNameIsExist(orgName)){
            throw  new ServiceException(ExceptionType.ORG_NAME_EXIST_EXCEPTION.value(),
                    ExceptionType.ORG_NAME_EXIST_EXCEPTION.desc());
        }
    }
    private void checkRegPhoneAndCodeExist(String phone,String phoneCode)throws  Exception{
        if(phoneIsExist(phone)) {
            throw new ServiceException(ExceptionType.PHONE_EXIST_EXCEPTION.value(),
                    ExceptionType.PHONE_EXIST_EXCEPTION.desc());
        }
        checkRegCodeExist(phone,phoneCode);
    }

    private  void  checkRegCodeExist(String phone,String phoneCode)throws  Exception{
        if(!smsMessageService.verificationCode(phone,phoneCode) ){
            throw  new ServiceException(ExceptionType.PHONE_CODE_VERITY_EXCEPTION.value(),
                    ExceptionType.PHONE_CODE_VERITY_EXCEPTION.desc());
        }
    }

    @Override
    protected IBaseDao<User,Integer> getBaseDao() {
        return userDao;
    }
}
