package com.alonelaval.cornerstone.servce.impl.platform;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.platform.RolePermissionDao;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.OrgPermission;
import com.alonelaval.cornerstone.entity.biz.Role;
import com.alonelaval.cornerstone.entity.biz.RolePermission;
import com.alonelaval.cornerstone.entity.biz.SysPermission;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.OrgPermissionService;
import com.alonelaval.cornerstone.service.platform.RolePermissionService;
import com.alonelaval.cornerstone.service.platform.RoleService;
import com.alonelaval.cornerstone.service.platform.SysPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("rolePermissionService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class RolePermissionServiceImpl extends AbstractBaseService<RolePermission,Integer> implements RolePermissionService {
    @Autowired
    RolePermissionDao rolePermissionDao;
    @Autowired
    SysPermissionService sysPermissionService;
    @Autowired
    OrgPermissionService orgPermissionService;
    @Autowired
    RoleService roleService;

    @Override
    protected IBaseDao<RolePermission,Integer> getBaseDao() {
        return rolePermissionDao;
    }

    @Override
    public RolePermission addRolePermission(RolePermission rolePermission) throws Exception {
        return  getBaseDao().addEntity(rolePermission);
    }

    @Override
    public List<RolePermission> findAllByRoleIdIn(List<Integer> ids) throws Exception {
        return Optional.of(rolePermissionDao.findAllByRoleIdIn(ids)).orElse(Collections.emptyList());
    }

    @Override
    public List<RolePermission> addRolePermissions(List<RolePermission> rolePermissions) throws Exception {
        return Optional.of(rolePermissionDao.addRolePermission(rolePermissions)).orElse(Collections.emptyList());
    }

    @Override
    public List<RolePermission> addRolePermissions(List<SysPermission> sysPermissions, Role role) throws Exception {
        List<RolePermission> rolePermissions = newArrayList();
        for(SysPermission sysPermission : sysPermissions){
            rolePermissions.add(this.addRolePermission(createRolePermission(sysPermission.getPermissionId(),
                    role.getRoleId())));
        }
        return rolePermissions;
    }

    @Override
    public List<RolePermission> addOrgRolePermissions(List<OrgPermission> orgPermissions, Role role) throws Exception {
        List<RolePermission> rolePermissions = newArrayList();
        for(OrgPermission orgPermission : orgPermissions){
            rolePermissions.add(this.addRolePermission(createOrgRolePermission(orgPermission,role.getRoleId())));
        }
        return rolePermissions;
    }

    @Override
    public List<RolePermission> addRoleSysPermissions(List<Integer> permissions, Integer roleId) throws Exception {

        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        if(userAdapter.getLoginType().equals(RoleOwnType.PLATFORM_ROLE)) {
            List<RolePermission> rolePermissions = findAllByRoleIdIn(newArrayList(roleId));

            for (RolePermission rolePermission : rolePermissions) {
                if (permissions.contains(rolePermission.getPermissionId())) {
                    rolePermission.setState(State.ENABLED);
                } else {
                    rolePermission.setState(State.DELETE);
                }
                permissions.remove(rolePermission.getPermissionId());
            }
            for (Integer permissionId : permissions) {
                rolePermissions.add(createRolePermission(permissionId, roleId));
            }

            return saveAll(rolePermissions);
        }
        throw new ServiceException(ExceptionType.NOT_AUTH.value(),ExceptionType.NOT_AUTH.desc());
    }

    @Override
    public List<RolePermission> addRoleOrgPermissions(List<Integer> opIds, Integer roleId) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        if(userAdapter.getOrg().isPresent() && userAdapter.getLoginType().equals(RoleOwnType.ORG_ROLE)){
            Optional<Role> optionalRole = roleService.findById(roleId);
            //机构必须是同一个
            if(optionalRole.isPresent() && optionalRole.get().getOrgId().equals(userAdapter.getOrg().get().getOrgId())) {

                List<RolePermission> rolePermissions = findAllByRoleIdIn(newArrayList(roleId));
                for (RolePermission rolePermission : rolePermissions) {
                    if (opIds.contains(rolePermission.getOpId())) {
                        rolePermission.setState(State.ENABLED);
                    } else {
                        rolePermission.setState(State.DELETE);
                    }
                    opIds.remove(rolePermission.getOpId());
                }

                for (Integer opId : opIds) {

                    rolePermissions.add(createOrgRolePermission(orgPermissionService.findById(opId).get(),
                            roleId));
                }
                return saveAll(rolePermissions);
            }
        }

        throw new ServiceException(ExceptionType.NOT_AUTH.value(),ExceptionType.NOT_AUTH.desc());
    }


    private RolePermission createOrgRolePermission(OrgPermission permission,Integer roleId){
        RolePermission rolePermission = RolePermission.builder()
                .permissionId(permission.getPermissionId())
                .opId(permission.getOpId())
                .orgId(permission.getOrgId())
                .orgName(permission.getOrgName())
                .roleId(roleId)
                .build();
        SetEntityProperties.getInstance().setProperties(rolePermission);
        return  rolePermission;
    }

    private RolePermission createRolePermission(Integer permissionId,Integer roleId){
        RolePermission rolePermission = RolePermission.builder()
                .permissionId(permissionId)
                .roleId(roleId)
                .build();
        SetEntityProperties.getInstance().setProperties(rolePermission);
        return  rolePermission;
    }




}
