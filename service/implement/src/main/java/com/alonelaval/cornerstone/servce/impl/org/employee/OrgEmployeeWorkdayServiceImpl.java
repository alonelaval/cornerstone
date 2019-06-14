package com.alonelaval.cornerstone.servce.impl.org.employee;

import com.google.common.collect.Lists;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeWorkdayDao;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeWorkday;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.DayType;
import com.alonelaval.cornerstone.entity.model.OrgEmployeeWorktimeModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeWorkdayService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeWorktimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgEmployeeWorkdayService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgEmployeeWorkdayServiceImpl extends AbstractBaseService<OrgEmployeeWorkday,Integer>
        implements OrgEmployeeWorkdayService {
    @Autowired
    OrgEmployeeWorkdayDao orgEmployeeWorkdayDao;
    @Autowired
    OrgEmployeeWorktimeService orgEmployeeWorktimeService;

    @Override
    protected IBaseDao<OrgEmployeeWorkday,Integer> getBaseDao() {
        return orgEmployeeWorkdayDao;
    }

    @Override
    public List<OrgEmployeeWorkday> addWorkdays(List<OrgEmployeeWorktimeModel> models,OrgEmployee employee) throws Exception {
        List<OrgEmployeeWorkday> workdays = Lists.newArrayList();
        if(models != null &&!models.isEmpty()){
            Map<DayType,List<OrgEmployeeWorktimeModel>> works = models.stream()
                    .collect(groupingBy(OrgEmployeeWorktimeModel::getDayType));
            OrgEmployeeWorkday workday =null;
            for(Map.Entry<DayType,List<OrgEmployeeWorktimeModel>> entry: works.entrySet()){

                workday = OrgEmployeeWorkday.builder()
                        .orgId(employee.getOrgId())
                        .orgName(employee.getOrgName())
                        .userId(employee.getUserId())
                        .userName(employee.getUserName())
                        .employeId(employee.getEmployeId())
                        .dayType(entry.getKey())
                        .build();
                SetEntityProperties.getInstance().setProperties(workday);

                workdays.add(this.add(workday));
                workday.setOrgEmployeeWorktimes(orgEmployeeWorktimeService.addWorkTime(entry.getValue(),workday));
            }
        }
        return  workdays;
    }

    @Override
    public List<OrgEmployeeWorkday> findAllByEmployeId(Integer employeId) throws Exception {
        return orgEmployeeWorkdayDao.findAllByEmployeId(employeId);
    }
}
