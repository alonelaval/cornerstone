package com.alonelaval.cornerstone.servce.impl.org.appointment;

import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgUserAppointmentDao;
import com.alonelaval.cornerstone.entity.biz.OrgUserAppointment;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.appointment.OrgUserAppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgUserAppointmentService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgUserAppointmentServiceImpl extends AbstractBaseService<OrgUserAppointment,Integer> implements OrgUserAppointmentService {
    @Autowired
    OrgUserAppointmentDao orgUserAppointmentDao;
    

    @Override
    protected IBaseDao<OrgUserAppointment,Integer> getBaseDao() {
        return orgUserAppointmentDao;
    }
}
