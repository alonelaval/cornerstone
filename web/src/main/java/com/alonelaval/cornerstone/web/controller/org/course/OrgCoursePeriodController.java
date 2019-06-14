package com.alonelaval.cornerstone.web.controller.org.course;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.OrgCoursePeriod;
import com.alonelaval.cornerstone.entity.model.OrgCoursePeriodModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.course.OrgCoursePeriodService;
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
@RequestMapping("org/course/period")
public class OrgCoursePeriodController extends AbstractController {

    @Autowired
    OrgCoursePeriodService orgCoursePeriodService;

    @PostMapping("add")
    public Object add(@Validated OrgCoursePeriodModel orgCoursePeriodModel) throws Exception {
       return  super.addBasic(orgCoursePeriodModel);
    }

    @PostMapping("update")
    public Object update(@Validated OrgCoursePeriodModel orgCoursePeriodModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orgCoursePeriodModel,id);
    }

    @PostMapping("list")
    public Object list(OrgCoursePeriodModel model, Page<OrgCoursePeriod> page) throws Exception {
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
        return orgCoursePeriodService;
    }

}
