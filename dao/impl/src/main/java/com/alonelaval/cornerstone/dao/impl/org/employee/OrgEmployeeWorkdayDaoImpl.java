package com.alonelaval.cornerstone.dao.impl.org.employee;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeWorkdayDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgEmployeeWorkdayRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgEmployeeWorkdayDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgEmployeeWorkdayRepository;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeWorkday;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgEmployeeWorkdayDao")
public class OrgEmployeeWorkdayDaoImpl  extends AbstractBaseDao<OrgEmployeeWorkday,Integer> implements OrgEmployeeWorkdayDao {

    @Autowired
    OrgEmployeeWorkdayRepository orgEmployeeWorkdayRepository;

    @Override
    protected BaseRepository<OrgEmployeeWorkday, Integer> getBaseRepository() {
        return orgEmployeeWorkdayRepository;
    }

    @Override
    public List<OrgEmployeeWorkday> findAllByEmployeId(Integer employeId) throws DaoException {
        try {
            return orgEmployeeWorkdayRepository.findAllByEmployeId(employeId);
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }
}
