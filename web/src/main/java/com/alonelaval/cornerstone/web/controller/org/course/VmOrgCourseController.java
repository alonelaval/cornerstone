package com.alonelaval.cornerstone.web.controller.org.course;


import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.VmOrgCourse;
import com.alonelaval.cornerstone.entity.model.VmOrgCourseModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.course.VmOrgCourseService;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author huawei
 * @create 2018-07-29
 **/
@Controller
@RequestMapping("course")
public class VmOrgCourseController extends AbstractController {

    @Autowired
    VmOrgCourseService vmOrgCourseService;


    @PostMapping("list")
    public Object list(VmOrgCourseModel model, Page<VmOrgCourse> page) throws Exception {
        return  super.listBasic(model,page);
    }

    @Override
    protected IBaseService getBaseService() {
        return vmOrgCourseService;
    }

}
