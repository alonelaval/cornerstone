package com.alonelaval.cornerstone.servce.impl.org.appointment;

import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgDisposeAppointmentDao;
import com.alonelaval.cornerstone.entity.biz.OrgDisposeAppointment;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.appointment.OrgDisposeAppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgDisposeAppointmentService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgDisposeAppointmentServiceImpl extends AbstractBaseService<OrgDisposeAppointment,Integer>  implements OrgDisposeAppointmentService {
    @Autowired
    OrgDisposeAppointmentDao orgDisposeAppointmentDao;
    

    @Override
    protected IBaseDao<OrgDisposeAppointment,Integer> getBaseDao() {
        return orgDisposeAppointmentDao;
    }
}
