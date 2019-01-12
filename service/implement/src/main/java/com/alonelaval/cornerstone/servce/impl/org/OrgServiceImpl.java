package com.alonelaval.cornerstone.servce.impl.org;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.common.message.SmsCodeGenerator;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.Org;
import com.alonelaval.cornerstone.entity.biz.QOrg;
import com.alonelaval.cornerstone.entity.biz.User;
import com.alonelaval.cornerstone.entity.constants.*;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.OrgModel;
import com.alonelaval.cornerstone.entity.model.UserModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.servce.impl.config.ServiceConfig;
import com.alonelaval.cornerstone.service.org.OrgPermissionService;
import com.alonelaval.cornerstone.service.org.OrgResourceService;
import com.alonelaval.cornerstone.service.org.OrgService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeService;
import com.alonelaval.cornerstone.service.platform.PlatformShopkeeperService;
import com.alonelaval.cornerstone.service.platform.RolePermissionService;
import com.alonelaval.cornerstone.service.platform.RoleService;
import com.alonelaval.cornerstone.service.platform.SysPermissionService;
import com.alonelaval.cornerstone.service.user.UserRoleService;
import com.alonelaval.cornerstone.service.user.UserService;
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
@Service("orgService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgServiceImpl extends AbstractBaseService<Org,Integer>  implements OrgService {
    @Autowired
    OrgDao orgDao;
    @Autowired
    OrgResourceService orgResourceService;
    @Autowired
    UserService userService;
    @Autowired
    OrgEmployeeService orgEmployeeService;
    @Autowired
    PlatformShopkeeperService platformShopkeeperService;
    @Autowired
    ServiceConfig serviceConfig;

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

    @Override
    public Page<Org> findByModelAndPage(Model model, Page<Org> page) throws Exception {
        OrgModel orgModel = (OrgModel) model;
        WhereBuilder builder = WhereBuilder.build();


        if(orgModel.getOrgState() != null ){
            builder.and(QOrg.org.state.eq(orgModel.getOrgState()));
        }
        if(orgModel.getAuditState()!= null) {
            builder.and(QOrg.org.auditState, orgModel.getAuditState());
        }


        builder.startWith(QOrg.org.orgName,orgModel.getOrgName());
        builder.startWith(QOrg.org.userName,orgModel.getUserName());
        builder.startWith(QOrg.org.userPhone,orgModel.getUserPhone());


        return orgDao.findAllByPredicateAndPage(builder.predicate(),page);
    }

    @Override
    protected IBaseDao<Org,Integer> getBaseDao() {
        return orgDao;
    }

    @Override
    public boolean orgNameIsExist(String orgName) throws Exception {
        return Optional.ofNullable(orgDao.findOrgByOrgName(orgName)).isPresent();
    }

    private UserAdapter orgRegister(OrgModel orgModel, List<String> resourceFiles) throws Exception {
       // TODO: 2018/8/8 需要发送密码到手机上
        UserAdapter userAdapter = userService.orgRegister(UserModel.builder()
                    .phone(orgModel.getUserPhone())
                    .userName(orgModel.getUserName())
                    .phoneCode(orgModel.getPhoneCode())
                    .loginPassword(SmsCodeGenerator.generateCode())
                    .gender(orgModel.getGender())
            .build(),orgModel);

        //添加资源
        userAdapter.getOrg().get().setOrgResources(
                orgResourceService.addOrgResource(resourceFiles,userAdapter.getOrg().get()
                        ,OrgResourceType.BUSINESS_LICENSE));

        return  userAdapter;
    }



    @Override
    public Org addOrg(OrgModel orgModel , User user) throws Exception {
        Org org = addOrgNotUpdateOrgCode(orgModel,user);
        org.setOrgCode(org.getId());
        return  update(org);
    }

    private Org addOrgNotUpdateOrgCode(OrgModel orgModel,User user) throws Exception {
        Org org = Org.builder()
                .orgName(orgModel.getOrgName())
                .userId(user.getUserId())
                .userName(user.getUserRealName())
                .userPhone(user.getPhone())
                .icon(orgModel.getIconPath())
                .orgLevel(orgModel.getOrgLevel())
                .remark(orgModel.getRemark())
                .build();
        org.setState(OrgState.WAITING);
        org.setAuditState(AuditState.WAIT_AUDIT);
        org.setCreateTime(LocalDateTime.now());
        return addOrg(org);
    }

    @Override
    public Org addOrgOrSubOrg(OrgModel orgModel, List<String> resourceFiles) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();

        //子机构
        if(orgModel.getOrgId() != null){
            if(userAdapter.getOrg().get().getOrgId().equals(orgModel.getOrgId())){
                UserAdapter subOrgUserAdapter = orgRegister(orgModel,resourceFiles);
                Org subOrg = subOrgUserAdapter.getOrg().get();

                //更新子机构的信息
                subOrg.setParentOrgId(userAdapter.getOrg().get().getOrgId());
                subOrg.setParentOrgName(userAdapter.getOrg().get().getOrgName());
                subOrg.setOrgCode(userAdapter.getOrg().get().getOrgId().toString().concat(".").concat(subOrg.getOrgId()
                        .toString()));
                subOrg.setOrgLevel((short) (userAdapter.getOrg().get().getOrgLevel().intValue() + 1));

                update(subOrg);

                return  subOrg;

            }
            //不能跨机构
            else {
                throw new ServiceException(ExceptionType.NOT_AUTH.value(),ExceptionType.NOT_AUTH.desc());
            }
        }

        //添加新机构
        if(userAdapter.getLoginType().equals(RoleOwnType.PLATFORM_ROLE)){
            orgModel.setOrgLevel(OrgModel.DEFAULT_ORG_LEVEL);
           return orgRegister(orgModel,resourceFiles).getOrg().get();
        }

        throw new ServiceException(ExceptionType.NOT_AUTH.value(),ExceptionType.NOT_AUTH.desc());
    }
}
