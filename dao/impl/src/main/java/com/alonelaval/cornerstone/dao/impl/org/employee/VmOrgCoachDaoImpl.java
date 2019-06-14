package com.alonelaval.cornerstone.dao.impl.org.employee;


import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.VmOrgCoachDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.VmOrgCoachRepository;
import com.alonelaval.cornerstone.entity.biz.VmOrgCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="vmOrgCoachDao")
public class VmOrgCoachDaoImpl  extends AbstractBaseDao<VmOrgCoach,Integer> implements VmOrgCoachDao {

    @Autowired
    VmOrgCoachRepository vmOrgCoachRepository;

    @Override
    protected BaseRepository<VmOrgCoach, Integer> getBaseRepository() {
        return vmOrgCoachRepository;
    }
}
