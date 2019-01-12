package com.alonelaval.cornerstone.service.org.course;


import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.VmOrgCourse;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface VmOrgCourseService  extends IBaseService<VmOrgCourse,Integer> {
    default VmOrgCourse addVmOrgCourse(VmOrgCourse vmOrgCourse) throws Exception{
    	return this.add(vmOrgCourse);
    }

}