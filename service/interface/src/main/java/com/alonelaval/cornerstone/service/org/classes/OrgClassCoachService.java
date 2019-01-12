package com.alonelaval.cornerstone.service.org.classes;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.OrgClass;
import com.alonelaval.cornerstone.entity.biz.OrgClassCoach;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;
import java.util.Optional;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgClassCoachService  extends IBaseService<OrgClassCoach,Integer> {
    default OrgClassCoach addOrgClassCoach(OrgClassCoach orgClassCoach) throws Exception{
        return  this.add(orgClassCoach);
    }

    /**
     * 添加教练
     * @param orgEmployees
     * @param orgClass
     * @return
     * @throws Exception
     */
    List<OrgClassCoach> addClassCoachs(List<OrgEmployee> orgEmployees, OrgClass orgClass) throws Exception;

    List<OrgClassCoach> addOrgCoachs(Integer classId, List<Integer> employeIds)throws  Exception;

    OrgClassCoach addOrUpdate(OrgClass orgClass, OrgEmployee orgEmployee) throws Exception;

    Optional<OrgClassCoach> findCoachByClassIdAndEmployeId(Integer classId,Integer employeId)throws Exception;
}