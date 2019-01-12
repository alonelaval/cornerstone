package com.alonelaval.cornerstone.service.org.arrange;

import com.alonelaval.cornerstone.entity.biz.OrgClassArrangeRecord;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgClassArrangeRecordService  extends IBaseService<OrgClassArrangeRecord,Integer> {
    default OrgClassArrangeRecord addOrgClassArrangeRecord(OrgClassArrangeRecord orgCourseArrange) throws Exception{
        return this.add(orgCourseArrange);
    }



}