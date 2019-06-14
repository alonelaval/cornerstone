package com.alonelaval.cornerstone.servce.impl.org.department;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgDepartmentDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.OrgDepartment;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.biz.QOrgDepartment;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.OrgDepartmentModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.department.OrgDepartmentService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgDepartmentService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgDepartmentServiceImpl extends AbstractBaseService<OrgDepartment,Integer>  implements OrgDepartmentService {
    @Autowired
    OrgDepartmentDao orgDepartmentDao;
    @Autowired
    OrgEmployeeService orgEmployeeService;


    @Override
    public Page<OrgDepartment> findByModelAndPage(Model model, Page<OrgDepartment> page) throws Exception {

        OrgDepartmentModel orgDepartmentModel = (OrgDepartmentModel) model;
        WhereBuilder builder = WhereBuilder.build();

        if(orgDepartmentModel.getState() == null ){
            builder.in(QOrgDepartment.orgDepartment.state,State.ENABLED,State.DISABLED);
        }else
        {
            builder.and(QOrgDepartment.orgDepartment.state.eq(orgDepartmentModel.getState()));
        }

        builder.startWith(QOrgDepartment.orgDepartment.departmentCode, orgDepartmentModel.getDepartmentCode());
        builder.startWith(QOrgDepartment.orgDepartment.departmentName, orgDepartmentModel.getDepartmentName());
        builder.and(QOrgDepartment.orgDepartment.employeId,orgDepartmentModel.getEmployeId());
        builder.and(QOrgDepartment.orgDepartment.orgId,orgDepartmentModel.getOrgId());


        return orgDepartmentDao.findAllByPredicateAndPage(builder.predicate(),page);
    }

    @Override
    public OrgDepartment add(Model model) throws Exception {
        OrgDepartmentModel orgDepartmentModel = (OrgDepartmentModel) model;
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        OrgEmployee orgEmployee = userAdapter.getOrgEmployee();
        if(orgDepartmentModel.getEmployeId() != null){
            Optional<OrgEmployee> optional = orgEmployeeService.findById(orgDepartmentModel.getEmployeId());
            //同一个机构
            if(optional.isPresent() && optional.get().getOrgId().equals(userAdapter.getOrg().get().getOrgId())){
                orgEmployee = optional.get();
            }
        }
        OrgDepartment orgDepartment = OrgDepartment.builder()
                .departmentName(orgDepartmentModel.getDepartmentName())
                .remark(orgDepartmentModel.getRemark())
                .level((short) 1)
                .orgId(orgEmployee.getOrgId())
                .orgName(orgEmployee.getOrgName())
                .userId(orgEmployee.getUserId())
                .userName(orgEmployee.getUserName())
                .employeId(orgEmployee.getEmployeId())
                .build();
        String departmentCode = "";
        if(orgDepartmentModel.getParentDepartmentId() != null){
            Optional<OrgDepartment> parent = orgDepartmentDao.findById(orgDepartmentModel.getParentDepartmentId());

            if(parent.isPresent() && parent.get().getOrgId().equals(userAdapter.getOrg().get().getOrgId())){
                departmentCode = parent.get().getDepartmentCode();
                orgDepartment.setParentDepartmentId(parent.get().getDepartmentId());
                orgDepartment.setParentDepartmentName(parent.get().getDepartmentName());
                orgDepartment.setLevel((short) (parent.get().getLevel()+1));
            }
        }
        SetEntityProperties.getInstance().setProperties(orgDepartment);

        orgDepartment = this.add(orgDepartment);

        orgDepartment.setDepartmentCode(departmentCode.equalsIgnoreCase("")? orgDepartment.getDepartmentId()+"":
                departmentCode.concat(".").concat(orgDepartment.getDepartmentId()+""));

        orgDepartment = this.update(orgDepartment);
        return orgDepartment;
    }

    @Override
    protected IBaseDao<OrgDepartment,Integer> getBaseDao() {
        return orgDepartmentDao;
    }
}
