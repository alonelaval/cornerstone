package com.alonelaval.cornerstone.servce.impl.org.classes;

import com.google.common.collect.Lists;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.OrgClassStudentDao;
import com.alonelaval.cornerstone.entity.biz.OrgClass;
import com.alonelaval.cornerstone.entity.biz.OrgClassStudent;
import com.alonelaval.cornerstone.entity.biz.OrgStudent;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.org.classes.OrgClassService;
import com.alonelaval.cornerstone.service.org.classes.OrgClassStudentService;
import com.alonelaval.cornerstone.service.org.student.OrgStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("orgClassStudentService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrgClassStudentServiceImpl extends AbstractBaseService<OrgClassStudent,Integer>  implements OrgClassStudentService {
    @Autowired
    OrgClassStudentDao orgClassStudentDao;
    @Autowired
    OrgClassService orgClassService;
    @Autowired
    OrgStudentService orgStudentService;
    

    @Override
    protected IBaseDao<OrgClassStudent,Integer> getBaseDao() {
        return orgClassStudentDao;
    }

    @Override
    public List<OrgClassStudent> addOrgClassStudents(List<OrgStudent> students, OrgClass orgClass) throws Exception {
        if(students != null && !students.isEmpty()){
            List<OrgClassStudent> classStudents = Lists.newArrayList();
            for(OrgStudent orgStudent : students){
                OrgClassStudent orgClassStudent = OrgClassStudent.builder()
                        .classId(orgClass.getClassId())
                        .className(orgClass.getClassName())
                        .courseId(orgClass.getCourseId())
                        .courseName(orgClass.getCourseName())
                        .orgId(orgClass.getOrgId())
                        .orgName(orgClass.getOrgName())
                        .userStudentId(orgStudent.getUserStudentId())
                        .studentUserId(orgStudent.getStudentUserId())
                        .studentUserName(orgStudent.getStudentUserName())
                        .orgStudentId(orgStudent.getOrgStudentId())
                        .build();

                SetEntityProperties.getInstance().setProperties(orgClassStudent);
                classStudents.add(this.add(orgClassStudent));
            }
            return  classStudents;
        }
        return Collections.EMPTY_LIST;
    }


    @Override
    public List<OrgClassStudent> addOrgStudents(Integer classId, List<Integer> orgStudentIds) throws Exception {
        if(orgStudentIds != null && !orgStudentIds.isEmpty()){
            Optional<OrgClass> optionalOrgClass = orgClassService.findById(classId);
            if(optionalOrgClass.isPresent()){
                List<OrgStudent> orgStudents =orgStudentService.findAllByIds(orgStudentIds);
                return this.addOrgClassStudents(orgStudents,optionalOrgClass.get());
            }
        }
        return  Collections.EMPTY_LIST;
    }
}
