package com.alonelaval.cornerstone.servce.impl.user;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.common.util.AssertUtil;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.UserRoleDao;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.*;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.RoleCreateType;
import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.OrgPermissionService;
import com.alonelaval.cornerstone.service.org.OrgService;
import com.alonelaval.cornerstone.service.platform.RolePermissionService;
import com.alonelaval.cornerstone.service.platform.RoleService;
import com.alonelaval.cornerstone.service.platform.SysPermissionService;
import com.alonelaval.cornerstone.service.user.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("userRoleService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UserRoleServiceImpl extends AbstractBaseService<UserRole,Integer> implements UserRoleService {
    @Autowired
    UserRoleDao userRoleDao;
    @Autowired
    RoleService roleService;
    @Autowired
    SysPermissionService sysPermissionService;
    @Autowired
    OrgPermissionService orgPermissionService;
    @Autowired
    RolePermissionService rolePermissionService;
    @Autowired
    OrgService orgService;

    @Override
    protected IBaseDao<UserRole,Integer> getBaseDao() {
        return userRoleDao;
    }

    @Override
    public UserRole addUserRole(UserRole userRole) throws Exception {
        return this.add(userRole);
    }

    @Override
    public List<UserRole> findAllByUserIdAndOwnTypeAndOrgId(Integer userId, RoleOwnType ownType, Integer orgId) throws Exception {
        return Optional.of(userRoleDao.findAllByUserIdAndOwnTypeAndOrgId(userId,ownType,orgId)).orElse(Collections.emptyList());
    }

    @Override
    public List<UserRole> findAllByUserIdAndOwnType(Integer userId, RoleOwnType ownType) throws Exception {
        return Optional.of(userRoleDao.findAllByUserIdAndOwnType(userId,ownType)).orElse(Collections.emptyList());
    }

    @Override
    public List<UserRole> findAllByUserIdAndOwnTypeAndOrgIdAndRoleIdIn(Integer userId, RoleOwnType ownType, Integer orgId, List<Integer> roleIds) throws Exception {
        return Optional.of(userRoleDao.findAllByUserIdAndOwnTypeAndOrgIdAndRoleIdIn(userId,ownType,orgId,roleIds)).orElse(Collections.emptyList());
    }

    @Override
    public List<UserRole> addOrgUserRole(List<Role> roles, Org org, User user) throws Exception {
        List<UserRole> userRoles = newArrayList();
        for(Role role : roles){
            UserRole userRole = UserRole.builder()
                    .roleId(role.getRoleId())
                    .userId(user.getUserId())
                    .orgId(org.getOrgId())
                    .orgName(org.getOrgName())
                    .ownType(RoleOwnType.ORG_ROLE)
                    .build();
            userRole.setState(State.ENABLED);
            userRole.setCreateTime(LocalDateTime.now());

            userRoles.add(addUserRole(userRole));
        }
        return userRoles;
    }

    @Override
    public List<UserRole> addUserRoles(List<Role> roles, User user) throws Exception {
        List<UserRole> userRoles = newArrayList();
        for(Role role : roles){
            userRoles.add(addUserRole(role,user,RoleOwnType.USER_ROLE));
        }
        return userRoles;
    }

    @Override
    public UserRole addUserRole(Role role, User user,RoleOwnType roleOwnType) throws Exception {
        UserRole userRole = UserRole.builder()
                .roleId(role.getRoleId())
                .userId(user.getUserId())
                .ownType(roleOwnType)
                .build();
        userRole.setState(State.ENABLED);
        userRole.setCreateTime(LocalDateTime.now());
        return addUserRole(userRole);
    }

    private UserRole createOrgUserRole(Integer userId,Integer orgId,String orgName,Role role){
        UserRole userRole = UserRole.builder()
                .roleId(role.getRoleId())
                .userId(userId)
                .orgId(orgId)
                .orgName(orgName)
                .ownType(RoleOwnType.ORG_ROLE)
                .build();
        SetEntityProperties.getInstance().setProperties(userRole);
        return  userRole;
    }

    @Override
    public List<UserRole> addOrgEmployeeRole(List<Integer> roleIds,OrgEmployee orgEmployee) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        if(userAdapter.getOrg().isPresent() && userAdapter.getLoginType().equals(RoleOwnType.ORG_ROLE)){
            //机构不匹配，授权错误
            AssertUtil.isTrue(!orgEmployee.getOrgId().equals(userAdapter.getOrg().get().getOrgId()),
                    new ServiceException(ExceptionType.NOT_AUTH.value(),ExceptionType.NOT_AUTH.desc()));
            List<UserRole> userRoles = findAllByUserIdAndOwnTypeAndOrgId(orgEmployee.getUserId(),
                    RoleOwnType.ORG_ROLE,orgEmployee.getOrgId());
            //取已经存在的权限
            userRoles.forEach(userRole -> {
                    if(roleIds.contains(userRole.getRoleId())){
                        userRole.setState(State.ENABLED);
                        roleIds.remove(userRole.getRoleId());
                        //移除已存在的
                    }else{
                        //需要删除的
                        userRole.setState(State.DELETE);
                    }
                }
            );
            List<Role> roles =roleService.findByIds(roleIds);
            //添加新的
            for (Role role : roles) {
                //只能添加自己机构
                if(null != role.getOrgId() && role.getOrgId().equals(orgEmployee.getOrgId())) {
                    userRoles.add(createOrgUserRole(orgEmployee.getUserId(), orgEmployee.getOrgId(), userAdapter.getOrg().get().getOrgName(), role));
                }
            }
            //保存进库
            userRoleDao.saveAll(userRoles);
            return userRoles;
        }
        throw new ServiceException(ExceptionType.ORG_NOT_FOUND.value(),ExceptionType.ORG_NOT_FOUND.desc());
    }




    @Override
    public List<UserRole> addPlatformShopkeeperRole(List<Integer> roleIds, PlatformShopkeeper platformShopkeeper) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        //当前登录的是机构用户，才有权限给机构分配角色，一旦分配了角色，
        // 会将当前角色的权限给添加到机构的权限里面去
        // 比如 试用版角色，高级版角色，初级版角色，
        if(userAdapter.getLoginType().equals(RoleOwnType.PLATFORM_ROLE)) {

            //找出原始角色
            //找出已经给当前操作的机构分配的角色
            List<Role> orgRoles = roleService.findByOrgIdAndCreateType(platformShopkeeper.getOrgId(),
                    RoleCreateType.PLATFORM_ALLOCATION);
            Org org =orgService.findById(platformShopkeeper.getOrgId()).get();

            Map<Integer,Role> orgRoleMap = new HashMap<>(16);
            for(Role role :orgRoles){
                orgRoleMap.put(role.getRoleId(),role);
            }

            //查找已分配的角色
            List<UserRole> userRoles = findAllByUserIdAndOwnTypeAndOrgIdAndRoleIdIn(platformShopkeeper.getUserId(),
                    RoleOwnType.ORG_ROLE, platformShopkeeper.getOrgId(),orgRoles.stream().mapToInt(Role::getRoleId)
                            .boxed().collect(Collectors.toList()));

            List<Integer> enableOrgRoleIds = new ArrayList<>();
            List<Integer> disableOrgRoleIds = new ArrayList<>();


            for (UserRole userRole : userRoles) {
                //已复制的角色
                if (roleIds.contains(orgRoleMap.get(userRole.getRoleId()).getFromRoleId())) {
                    // 启用角色
                    enableOrgRoleIds.add(userRole.getRoleId());
                    //启用用户角色关系
                    userRole.setState(State.ENABLED);
                    //移除已存在的
                    roleIds.remove(orgRoleMap.get(userRole.getRoleId()).getFromRoleId());
                    //查找对应的权限,设置为启用
                    List<RolePermission> rolePermissions = rolePermissionService.findAllByRoleIdIn(
                            newArrayList(userRole.getRoleId()));

                    // TODO: 2018/8/2 必须根据机构ID和permissionID来启用
                    orgPermissionService.enableAllByOrgId(rolePermissions.stream().mapToInt(RolePermission::getPermissionId)
                            .boxed().collect(Collectors.toList()),platformShopkeeper.getOrgId());
                } else {

                    disableOrgRoleIds.add(userRole.getRoleId());
                    userRole.setState(State.DELETE);

                    List<RolePermission> rolePermissions = rolePermissionService.findAllByRoleIdIn(newArrayList(userRole.getRoleId()));

                    //需要删除的 // TODO: 2018/8/1 该机构下面的所有的该角色的权限都给禁用了，删除了角色的情况下。

                    orgPermissionService.deleteAllByOrgId(rolePermissions.stream().mapToInt(RolePermission::getPermissionId)
                            .boxed().collect(Collectors.toList()),platformShopkeeper.getOrgId());
                }
            }
            //启用已经复制过的
            if(!enableOrgRoleIds.isEmpty()){
                roleService.enable(enableOrgRoleIds);
            }
            //删除这次没有授权的
            if(!disableOrgRoleIds.isEmpty()) {
                roleService.disable(disableOrgRoleIds);
            }

            List<Role> roles =roleService.findByIds(roleIds);
            //添加新的
            for (Role role : roles) {

                List<RolePermission> rolePermissions = rolePermissionService.findAllByRoleIdIn(newArrayList(role.getRoleId()));
                List<SysPermission> sysPermissions = sysPermissionService.findAllByPermissionIdIn(rolePermissions.stream()
                        .mapToInt(RolePermission::getPermissionId).boxed().collect(Collectors.toList()));
                //设置机构权限
                List<OrgPermission> orgPermissions = orgPermissionService.addOrgPermissionsBySysPermissions(sysPermissions,
                        org);

                //复制角色
                Role orgRole = roleService.copyRoleToOrg(role,
                        org,
                        OrgEmployee.builder().userId(platformShopkeeper.getUserId()).userName(platformShopkeeper.getUserName())
                                .employeId(platformShopkeeper.getEmployeId()).build()
                        );
                orgRole = roleService.addRole(orgRole);
                //给当前机构复制权限
                userRoles.add(createOrgUserRole(platformShopkeeper.getUserId(),platformShopkeeper.getOrgId()
                        ,org.getOrgName(),orgRole));
                //给新角色授权
                rolePermissionService.addOrgRolePermissions(orgPermissions,orgRole);
            }
            userRoleDao.saveAll(userRoles);
            return  userRoles;
        }
        throw new ServiceException(ExceptionType.NOT_AUTH.value(),ExceptionType.NOT_AUTH.desc());
    }


}
