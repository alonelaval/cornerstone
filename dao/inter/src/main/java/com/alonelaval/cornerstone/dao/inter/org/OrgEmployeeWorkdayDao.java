package com.alonelaval.cornerstone.dao.inter.org;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeWorkday;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface OrgEmployeeWorkdayDao  extends IBaseDao<OrgEmployeeWorkday,Integer> {
    List<OrgEmployeeWorkday> findAllByEmployeId(Integer employeId)throws DaoException;
}
