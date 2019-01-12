package com.alonelaval.cornerstone.dao.repository.jpa.biz;

import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.constants.IsCoach;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-111
 * create by python 
 **/
@Repository
public interface OrgEmployeeRepository extends BaseRepository<OrgEmployee,Integer> {
    OrgEmployee findByOrgIdAndUserId(Integer orgId,Integer userId);
    List<OrgEmployee> findAllByOrgId(Integer orgId);

    List<OrgEmployee> findAllByOrgIdAndIsCoach(Integer orgId, IsCoach isCoach);

    List<OrgEmployee> findAllByEmployeIdInAndIsCoach(List<Integer> employeIds,IsCoach isCoach);

}
