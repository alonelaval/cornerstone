package com.alonelaval.cornerstone.web.controller.org.employee;


import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.VmOrgCoach;
import com.alonelaval.cornerstone.entity.model.VmOrgCoachModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.employee.VmOrgCoachService;
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
@RequestMapping("org/coach")
public class VmOrgCoachController extends AbstractController {

    @Autowired
    VmOrgCoachService vmOrgCoachService;

    @PostMapping("list")
    public Object list(VmOrgCoachModel model, Page<VmOrgCoach> page) throws Exception {
        return  super.listBasic(model,page);
    }
    @Override
    protected IBaseService getBaseService() {
        return vmOrgCoachService;
    }

}
