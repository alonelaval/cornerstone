package com.alonelaval.cornerstone.service.platform;

import com.alonelaval.cornerstone.entity.biz.Org;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.biz.Role;
import com.alonelaval.cornerstone.entity.biz.User;
import com.alonelaval.cornerstone.entity.constants.RoleCreateType;
import com.alonelaval.cornerstone.entity.model.RoleModel;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface RoleService  extends IBaseService<Role,Integer> {
    Role addRole(Role role) throws Exception;
    List<Role> findByIds(List<Integer> ids)throws Exception;

    /***
     * 为机构复制默认角色
     * @param ids
     * @param org
     * @return
     */
    List<Role> copyDefaultRolesToOrg(List<Integer> ids, Org org, OrgEmployee orgEmployee)throws  Exception;
    Role copyRoleToOrg(Role role, Org org, OrgEmployee orgEmployee)throws  Exception;

    List<Role> findByOrgId(Integer orgId) throws  Exception;

    List<Role> findByOrgIdAndFromRoleId(Integer orgId,List<Integer> fromRoleIds)throws  Exception;

    /**
     * 找出平台给系统分配的角色
     * @param orgId
     * @return
     * @throws Exception
     */
    List<Role> findByOrgIdAndCreateType(Integer orgId, RoleCreateType roleCreateType)throws  Exception;

    Role addOrgRole(RoleModel model)throws  Exception;
    Role addPlatformRole(RoleModel model)throws  Exception;

    /**
     *  TODO: 2018/7/22 添加默认C端角色,如果不是新注册用户，添加已存在的C端角色
     * @param user
     * @param isNewUser
     * @return
     * @throws Exception
     */
    List<Role> createOrFindClientUserRole(User user,Boolean isNewUser)throws  Exception;



}