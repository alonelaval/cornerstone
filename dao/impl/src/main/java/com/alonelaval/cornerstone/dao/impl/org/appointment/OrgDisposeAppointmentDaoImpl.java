package com.alonelaval.cornerstone.dao.impl.org.appointment;

import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgDisposeAppointmentDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgDisposeAppointmentRepository;
import com.alonelaval.cornerstone.entity.biz.OrgDisposeAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgDisposeAppointmentDao")
public class OrgDisposeAppointmentDaoImpl  extends AbstractBaseDao<OrgDisposeAppointment,Integer> implements OrgDisposeAppointmentDao {

    @Autowired
    OrgDisposeAppointmentRepository orgDisposeAppointmentRepository;

    @Override
    protected BaseRepository<OrgDisposeAppointment, Integer> getBaseRepository() {
        return orgDisposeAppointmentRepository;
    }
}
