package com.alonelaval.cornerstone.service.org.student;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.Org;
import com.alonelaval.cornerstone.entity.biz.OrgStudent;
import com.alonelaval.cornerstone.entity.biz.User;
import com.alonelaval.cornerstone.entity.biz.UserStudent;
import com.alonelaval.cornerstone.entity.model.OrgStudentModel;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.Optional;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgStudentService  extends IBaseService<OrgStudent,Integer> {
    default OrgStudent addOrgStudent(OrgStudent orgStudent) throws Exception{
        return  this.add(orgStudent);
    }
    OrgStudent addStudent(OrgStudentModel orgStudentModel)throws  Exception;

    /**
     * 根据用户的学员，比如儿子，小孩，朋友找学员
     * @param userStudentId
     * @return
     * @throws Exception
     */
    Optional<OrgStudent> findByUserStudentId(Integer userStudentId)throws  Exception;

    /**
     * 根据用户ID找学员，如果用户是自己报名的情况下
     * @param studentUserId
     * @return
     * @throws Exception
     */
    Optional<OrgStudent> findByStudentUserId(Integer studentUserId)throws  Exception;

    /**
     * 添加机构学员,没有没有指定学员，user为默认的学员
     * @param userStudent
     * @param user
     * @return
     * @throws Exception
     */
    OrgStudent addStudent(UserStudent userStudent, User user,Org org)throws Exception;
}
