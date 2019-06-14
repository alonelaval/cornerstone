package com.alonelaval.cornerstone.service.org.classes;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.OrgClass;
import com.alonelaval.cornerstone.entity.model.OrgClassModel;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgClassService  extends IBaseService<OrgClass,Integer> {
    default OrgClass addOrgClass(OrgClass orgClass) throws Exception{
        return this.add(orgClass);
   }

    /***
     * 添加或者删除教练
     * @param classModel
     * @return
     * @throws Exception
     */
   OrgClass changeMainCoach(OrgClassModel classModel)throws Exception;

}