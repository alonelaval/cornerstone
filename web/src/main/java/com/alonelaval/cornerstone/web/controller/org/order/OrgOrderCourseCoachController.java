package com.alonelaval.cornerstone.web.controller.org.order;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.entity.biz.OrgOrderCourseCoach;
import com.alonelaval.cornerstone.entity.model.OrgOrderCourseCoachModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.order.OrgOrderCourseCoachService;
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
@RequestMapping("org/order/course/coach")
public class OrgOrderCourseCoachController extends AbstractController {

    @Autowired
    OrgOrderCourseCoachService orgOrderCourseCoachService;

    @PostMapping("add")
    public Object add(@Validated OrgOrderCourseCoachModel orgOrderCourseCoachModel) throws Exception {
       return  super.addBasic(orgOrderCourseCoachModel);
    }

    @PostMapping("update")
    public Object update(@Validated OrgOrderCourseCoachModel orgOrderCourseCoachModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orgOrderCourseCoachModel,id);
    }

    @PostMapping("list")
    public Object list(OrgOrderCourseCoachModel model, Page<OrgOrderCourseCoach> page) throws Exception {
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
        return orgOrderCourseCoachService;
    }

}
