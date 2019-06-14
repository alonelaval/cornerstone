package com.alonelaval.cornerstone.servce.impl.user;


import com.alonelaval.cornerstone.dao.inter.user.UserDao;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.*;
import com.alonelaval.cornerstone.entity.constants.EmployeeState;
import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.service.org.OrgPermissionService;
import com.alonelaval.cornerstone.service.org.OrgService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeService;
import com.alonelaval.cornerstone.service.platform.PlatformShopkeeperService;
import com.alonelaval.cornerstone.service.platform.RolePermissionService;
import com.alonelaval.cornerstone.service.platform.RoleService;
import com.alonelaval.cornerstone.service.platform.SysPermissionService;
import com.alonelaval.cornerstone.service.user.CustomUserDetailsService;
import com.alonelaval.cornerstone.service.user.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * @author huawei
 * @create 2018-07-13
 **/
@Service("userDetailsService")
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private OrgService orgService;
    @Autowired
    private OrgEmployeeService orgEmployeeService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RolePermissionService rolePermissionService;
    @Autowired
    private SysPermissionService sysPermissionService;
    @Autowired
    private OrgPermissionService orgPermissionService;
    @Autowired
    private PlatformShopkeeperService platformShopkeeperService;

    @Override
    public UserDetails loadUserByUsernameAndOrgId(String username, String password,Integer orgId,RoleOwnType loginType,PasswordEncoder passwordEncoder) throws AuthenticationException {
        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("用户名不能为空!");
        }
        log.info("orgID:{},loginType:{}",orgId,loginType);
        try {
            User user = null;
            Org org = null;
            OrgEmployee orgEmployee = null;
            PlatformShopkeeper platformShopkeeper=null;

            user = userDao.findByLoginName(username);
            if (user == null) {
                user = userDao.findByPhone(username);
            } else if (user == null) {
                user = userDao.findByEmail(username);
            }
            if (user == null) {
                throw new UsernameNotFoundException(
                        String.format("用户名错误！", username));
            }
            if (user != null) {

                if(!checkPassword(password,user.getLoginPassword(),passwordEncoder)){
                    throw  new UsernameNotFoundException("密码错误！");
                }

                if(!user.getState().equals(State.ENABLED)){
                    throw  new UsernameNotFoundException("用户已经被禁用！");
                }

                List<UserRole> userRoles = null;
                if (RoleOwnType.ORG_ROLE ==  loginType && orgId != null ) {

                    Optional<Org>  optionalOrg = orgService.findById(orgId);
                    if(!optionalOrg.isPresent()){
                        throw  new UsernameNotFoundException("机构不存在！");
                    }
                    org = optionalOrg.get();

                    Optional<OrgEmployee> optional= orgEmployeeService.findByOrgIdAndUserId(org.getOrgId(),user.getUserId());
                    if(!optional.isPresent()){
                        throw  new UsernameNotFoundException("用户不是该机构的员工！");
                    }
                    orgEmployee = optional.get();
                    if(!EmployeeState.isNormal(orgEmployee.getState().value())){
                        throw  new UsernameNotFoundException("用户已经被机构禁用！");
                    }

                    platformShopkeeper = platformShopkeeperService.findByUserId(user.getUserId());

                    userRoles = userRoleService.findAllByUserIdAndOwnTypeAndOrgId(user.getUserId(),loginType, orgId);
                    if(userRoles==null || userRoles.isEmpty()){
                        throw  new UsernameNotFoundException("用户在机构没有分配角色，请联系机构的管理员！");
                    }
                    List<Integer> ids = userRoles.stream().mapToInt(UserRole::getRoleId).boxed().collect(Collectors.toList());
                    List<RolePermission> rolePermissions =  rolePermissionService .findAllByRoleIdIn(ids);

                    List<Integer> opIds = rolePermissions.stream().mapToInt(RolePermission::getOpId).boxed().collect(Collectors.toList());
                    user.setPermissions(orgPermissionService.findAllByOpIdIn(opIds));
                    user.setRoles(roleService.findByIds(ids));
                } else {
                    userRoles = userRoleService.findAllByUserIdAndOwnType(user.getUserId(),loginType);
                    List<Integer> ids = userRoles.stream().mapToInt(UserRole::getRoleId).boxed().collect(Collectors.toList());
                    user.setRoles(roleService.findByIds(ids));
                    List<RolePermission> rolePermissions =  rolePermissionService.findAllByRoleIdIn(ids);
                    List<Integer> permissionIds = rolePermissions.stream().mapToInt(RolePermission::getPermissionId).boxed().collect(Collectors.toList());

                    user.setPermissions(sysPermissionService.findAllByPermissionIdIn(permissionIds));
                }

            }
            return new UserAdapter(user, org ,orgEmployee,loginType,platformShopkeeper);

        }catch (UsernameNotFoundException e){
            throw e;
        }
        catch (Exception e) {
            throw  new UsernameNotFoundException("登录异常，请联系系统管理员！",e);
        }
    }


    private boolean checkPassword(String password,String  encodPwd,PasswordEncoder passwordEncoder) {
        return  passwordEncoder.matches(password,encodPwd);
    }

}