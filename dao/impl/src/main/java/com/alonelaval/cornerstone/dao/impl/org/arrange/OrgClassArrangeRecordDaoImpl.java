package com.alonelaval.cornerstone.dao.impl.org.arrange;

import com.alonelaval.cornerstone.dao.inter.org.OrgClassArrangeRecordDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgClassArrangeRecordRepository;
import com.alonelaval.cornerstone.dao.impl.AbstractBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgClassArrangeRecordDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.OrgClassArrangeRecordRepository;
import com.alonelaval.cornerstone.entity.biz.OrgClassArrangeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huawei
 * @create 2018-07-08
 **/
@Component(value="orgClassArrangeRecordDao")
public class OrgClassArrangeRecordDaoImpl extends AbstractBaseDao<OrgClassArrangeRecord,Integer> implements OrgClassArrangeRecordDao {

    @Autowired
    OrgClassArrangeRecordRepository orgCourseArrangRepository;

    @Override
    protected BaseRepository<OrgClassArrangeRecord, Integer> getBaseRepository() {
        return orgCourseArrangRepository;
    }
}
