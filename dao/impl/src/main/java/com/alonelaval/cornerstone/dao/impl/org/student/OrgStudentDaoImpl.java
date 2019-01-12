package com.alonelaval.cornerstone.dao.impl.org.student;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.inter.org.OrgStudentDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgStudentRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgStudentDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgStudentRepository;
import com.alonelaval.cornerstone.entity.biz.OrgStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgStudentDao")
public class OrgStudentDaoImpl  extends AbstractBaseDao<OrgStudent,Integer> implements OrgStudentDao {

    @Autowired
    OrgStudentRepository orgStudentRepository;

    @Override
    protected BaseRepository<OrgStudent, Integer> getBaseRepository() {
        return orgStudentRepository;
    }

    @Override
    public Optional<OrgStudent> findByUserStudentId(Integer userStudentId) throws DaoException {
        return Optional.ofNullable(orgStudentRepository.findByUserStudentId(userStudentId));
    }

    @Override
    public Optional<OrgStudent> findByStudentUserId(Integer studentUserId) throws DaoException {
        return Optional.ofNullable(orgStudentRepository.findByStudentUserId(studentUserId));
    }



}
