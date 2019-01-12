package com.alonelaval.cornerstone.web.controller.org.course;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.OrgCourseResource;
import com.alonelaval.cornerstone.entity.model.OrgCourseResourceModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.course.OrgCoursePlaceService;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;


/**
 * @author huawei
 * @create 2018-07-29
 **/
@Controller
@RequestMapping("org/course/place")
public class OrgCoursePlaceController extends AbstractController {

    @Autowired
    OrgCoursePlaceService orgCoursePlaceService;

    @PostMapping("add")
    public Object add(@Validated OrgCourseResourceModel orgCourseResourceModel) throws Exception {
       return  super.addBasic(orgCourseResourceModel);
    }

    @PostMapping("update")
    public Object update(@Validated OrgCourseResourceModel orgCourseResourceModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orgCourseResourceModel,id);
    }

    @PostMapping("list")
    public Object list(OrgCourseResourceModel model, Page<OrgCourseResource> page) throws Exception {
        return  super.listBasic(model,page);
    }

    @PostMapping("/disable")

    public Object disable(@NotNull(message = "ID不能为空!")  Integer ... ids)throws  Exception{
        return  super.disableBasic(ids);
    }
    @PostMapping("/enable")

    public Object enable(@NotNull(message = "ID不能为空!")  Integer ... ids)throws  Exception{
        return  super.enableBasic(ids);
    }
    @PostMapping("/delete")

    public Object delete(@NotNull(message = "ID不能为空!")  Integer ... ids)throws  Exception{
        return  super.deleteBasic(ids);
    }

    @Override
    protected IBaseService getBaseService() {
        return orgCoursePlaceService;
    }

}
