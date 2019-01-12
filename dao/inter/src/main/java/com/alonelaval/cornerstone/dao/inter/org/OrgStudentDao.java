package com.alonelaval.cornerstone.dao.inter.org;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.entity.biz.OrgStudent;

import java.util.Optional;

/**
 * @author huawei
 * @create 2018-07-11
 * create by python
 **/
public interface OrgStudentDao  extends IBaseDao<OrgStudent,Integer> {
    Optional<OrgStudent> findByUserStudentId(Integer userStudentId)throws DaoException;
    Optional<OrgStudent> findByStudentUserId(Integer studentUserId)throws DaoException;
}
