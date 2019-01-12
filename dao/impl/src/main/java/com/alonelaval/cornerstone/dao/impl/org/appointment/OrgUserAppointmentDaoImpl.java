package com.alonelaval.cornerstone.dao.impl.org.appointment;

import com.alonelaval.cornerstone.dao.inter.org.OrgUserAppointmentDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgUserAppointmentRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgUserAppointmentDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgUserAppointmentRepository;
import com.alonelaval.cornerstone.entity.biz.OrgUserAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgUserAppointmentDao")
public class OrgUserAppointmentDaoImpl  extends AbstractBaseDao<OrgUserAppointment,Integer> implements OrgUserAppointmentDao {

    @Autowired
    OrgUserAppointmentRepository orgUserAppointmentRepository;

    @Override
    protected BaseRepository<OrgUserAppointment, Integer> getBaseRepository() {
        return orgUserAppointmentRepository;
    }
}
