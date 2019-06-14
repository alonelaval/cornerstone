package com.alonelaval.cornerstone.service.org.classes;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.OrgClass;
import com.alonelaval.cornerstone.entity.biz.OrgClassStudent;
import com.alonelaval.cornerstone.entity.biz.OrgStudent;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgClassStudentService  extends IBaseService<OrgClassStudent,Integer> {
    default OrgClassStudent addOrgClassStudent(OrgClassStudent orgClassStudent) throws Exception{
        return  this.addOrgClassStudent(orgClassStudent);
   }
    List<OrgClassStudent> addOrgClassStudents(List<OrgStudent> students, OrgClass orgClass)throws Exception;

    /**
     * 添加机构学生
     * @param classId
     * @param orgStudentIds
     */
    List<OrgClassStudent> addOrgStudents(Integer classId ,List<Integer> orgStudentIds) throws Exception;
}