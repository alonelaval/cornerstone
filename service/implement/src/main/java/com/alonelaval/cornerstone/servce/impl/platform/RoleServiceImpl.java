package com.alonelaval.cornerstone.servce.impl.platform;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.platform.RoleDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.*;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.RoleCreateType;
import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.RoleModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.servce.impl.config.ServiceConfig;
import com.alonelaval.cornerstone.service.platform.RoleService;
import com.alonelaval.cornerstone.service.user.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("roleService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends AbstractBaseService<Role,Integer>  implements RoleService {
    @Autowired
    RoleDao roleDao;
    @Autowired
    ServiceConfig serviceConfig;
    @Autowired
    UserRoleService userRoleService;

    @Override
    protected IBaseDao<Role,Integer> getBaseDao() {
        return roleDao;
    }

    @Override
    public Role addRole(Role role) throws Exception {
        return add(role);
    }

    @Override
    public Page<Role> findByModelAndPage(Model model, Page<Role> page) throws Exception {
        RoleModel roleModel = (RoleModel) model;
        WhereBuilder builder = WhereBuilder.build();

        if(roleModel.getState() == null ){
            builder.in(QRole.role.state,State.ENABLED,State.DISABLED);
        }else
        {
            builder.and(QRole.role.state.eq(roleModel.getState()));
        }

        builder.and(QRole.role.orgId,roleModel.getOrgId());
        builder.startWith(QRole.role.roleCode,roleModel.getRoleCode());
        builder.startWith(QRole.role.roleName,roleModel.getRoleName());

        return  getBaseDao().findAllByPredicateAndPage(builder.predicate(),page);
    }

    @Override
    public List<Role> findByIds(List<Integer> ids) throws Exception {
        return roleDao.findByIds(ids).orElse(Collections.emptyList());
    }

    @Override
    public List<Role> copyDefaultRolesToOrg(List<Integer> ids, Org org,OrgEmployee orgEmployee) throws Exception {
        List<Role> exampleRoles =findByIds(ids);
        List<Role> defaultRoles = newArrayList();
        for(Role role : exampleRoles){
            Role tempRole = copyRoleToOrg(role,org,orgEmployee);
            defaultRoles.add(addRole(tempRole));
        }
        return defaultRoles;
    }

    @Override
    public Role copyRoleToOrg(Role role, Org org, OrgEmployee orgEmployee) throws Exception {
        Role tempRole = new Role();
        //还是copy了
        tempRole.setRoleCode(role.getRoleCode());
        tempRole.setRoleDesc(role.getRoleDesc());
        tempRole.setRoleName(role.getRoleName());
        tempRole.setOrgId(org.getOrgId());
        tempRole.setAddEmployId(orgEmployee.getEmployeId());
        tempRole.setAddUserName(orgEmployee.getUserName());
        tempRole.setAddUserId(orgEmployee.getUserId());
        tempRole.setOrgName(org.getOrgName());
        tempRole.setOwnType(RoleOwnType.ORG_ROLE);
        tempRole.setState(State.ENABLED);
        tempRole.setCreateTime(LocalDateTime.now());
        //标记从哪个系统角色来的
        tempRole.setCreateType(RoleCreateType.PLATFORM_ALLOCATION);
        tempRole.setFromRoleId(role.getRoleId());
        return tempRole;
    }

    @Override
    public List<Role> findByOrgId(Integer orgId) throws Exception {
        return roleDao.findByOrgId(orgId).orElse(Collections.emptyList());
    }

    @Override
    public List<Role> findByOrgIdAndFromRoleId(Integer orgId, List<Integer> fromRoleIds) throws Exception {
        return roleDao.findByOrgIdAndFromRoleId(orgId,fromRoleIds).orElse(Collections.emptyList());
    }

    @Override
    public List<Role> findByOrgIdAndCreateType(Integer orgId, RoleCreateType roleCreateType) throws Exception {
        return roleDao.findByOrgIdAndCreateType(orgId,roleCreateType).orElse(Collections.emptyList());
    }

    @Override
    public Role addOrgRole(RoleModel model) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        if(userAdapter.getOrg().isPresent() && userAdapter.getLoginType().equals(RoleOwnType.ORG_ROLE)) {
            Role role = Role.builder().roleDesc(model.getRoleDesc())
                    .roleCode(model.getRoleCode())
                    .roleName(model.getRoleName())
                    .addEmployId(userAdapter.getOrgEmployee().getEmployeId())
                    .addUserId(userAdapter.getUser().getUserId())
                    .addUserName(userAdapter.getUser().getUserRealName())
                    .orgId(userAdapter.getOrg().get().getOrgId())
                    .orgName(userAdapter.getOrg().get().getOrgName())
                    .createType(RoleCreateType.ORG_CREATION)
                    .ownType(RoleOwnType.ORG_ROLE)
                    .build();

            SetEntityProperties.getInstance().setProperties(role);
            return  add(role);
        }

        throw new ServiceException(ExceptionType.NOT_AUTH.value(),ExceptionType.NOT_AUTH.desc());
    }

    @Override
    public Role addPlatformRole(RoleModel model) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        if(userAdapter.getLoginType().equals(RoleOwnType.PLATFORM_ROLE)) {
            Role role = Role.builder().roleDesc(model.getRoleDesc())
                    .roleCode(model.getRoleCode())
                    .roleName(model.getRoleName())
                    .addUserId(userAdapter.getUser().getUserId())
                    .addUserName(userAdapter.getUser().getUserRealName())
                    .createType(RoleCreateType.PLATFORM_CREATION)
                    .ownType(RoleOwnType.PLATFORM_ROLE)
                    .build();
            SetEntityProperties.getInstance().setProperties(role);
            return  add(role);
        }

        throw new ServiceException(ExceptionType.NOT_AUTH.value(),ExceptionType.NOT_AUTH.desc());
    }

    @Override
    public List<Role> createOrFindClientUserRole(User user, Boolean isNewUser) throws Exception {
        if(isNewUser) {
            List<Role> roles = findByIds(serviceConfig.getClientDefaultRoleIdList());
            for(Role role :roles){
                userRoleService.addUserRole(role, user, RoleOwnType.USER_ROLE);
            }
            return  roles;
        }
        List<UserRole> userRoles = userRoleService.findAllByUserIdAndOwnType(user.getUserId(),RoleOwnType.USER_ROLE);
        return findByIds(userRoles.stream().mapToInt(UserRole::getRoleId).boxed().collect(Collectors.toList()));
    }
}
