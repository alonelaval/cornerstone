package com.alonelaval.cornerstone.service.org.employee;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.Org;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.biz.User;
import com.alonelaval.cornerstone.entity.constants.EmployeeState;
import com.alonelaval.cornerstone.entity.constants.IsCoach;
import com.alonelaval.cornerstone.entity.constants.OrgAccountType;
import com.alonelaval.cornerstone.entity.model.CoachModel;
import com.alonelaval.cornerstone.entity.model.OrgEmployeeModel;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;
import java.util.Optional;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgEmployeeService  extends IBaseService<OrgEmployee,Integer> {
    default OrgEmployee addOrgEmployee(OrgEmployee orgEmployee) throws Exception{
        return this.add(orgEmployee);
   }
    Optional<OrgEmployee> findByOrgIdAndUserId(Integer orgId, Integer userId)throws Exception;



    OrgEmployee createOrgEmployee(Org org, User user, EmployeeState employeeState, OrgAccountType orgAccountType, IsCoach isCoach) throws Exception;

    /**
     * 创建教练表
     * @return
     * @throws Exception
     */
    OrgEmployee addCoach(CoachModel coachModel)throws  Exception;


    /***
     * 查找机构员工
     * @param orgId
     * @return
     * @throws Exception
     */
    List<OrgEmployee> findAllByOrgId(Integer orgId)throws  Exception;

    /**
     * 查找本机构所有的教练
     * @param orgId
     * @return
     * @throws Exception
     */
    List<OrgEmployee> findAllCoachByOrgId(Integer orgId)throws  Exception;

    /**
     * 查找本机构所有的教练
     * @param orgId
     * @return
     * @throws Exception
     */
    List<OrgEmployee> findAllCoachByEmployeIds(List<Integer> employeIds)throws  Exception;

    /**
     * 修改机构用户信息
     * @param employeeModel
     * @param resourceFileNames
     * @param iconFile
     * @return
     */
    OrgEmployee updateInfo(OrgEmployeeModel employeeModel, List<String> resourceFileNames, String icon)throws Exception;
}