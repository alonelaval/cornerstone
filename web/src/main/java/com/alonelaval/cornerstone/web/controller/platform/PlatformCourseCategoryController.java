package com.alonelaval.cornerstone.web.controller.platform;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.PlatformCourseCategory;
import com.alonelaval.cornerstone.entity.model.PlatformCourseCategoryModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.platform.PlatformCourseCategoryService;
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
 *
 **/
@Controller
@RequestMapping("platform/course/category")
public class PlatformCourseCategoryController extends AbstractController {

    @Autowired
    PlatformCourseCategoryService platformCourseCategoryService;

    @PostMapping("add")
    public Object add(@Validated PlatformCourseCategoryModel platformCourseCategoryModel) throws Exception {
       return  super.addBasic(platformCourseCategoryModel);
    }

    @PostMapping("update")
    public Object update(@Validated PlatformCourseCategoryModel platformCourseCategoryModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(platformCourseCategoryModel,id);
    }

    @PostMapping("list")
    public Object list(PlatformCourseCategoryModel model, Page<PlatformCourseCategory> page) throws Exception {
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
        return platformCourseCategoryService;
    }

}
