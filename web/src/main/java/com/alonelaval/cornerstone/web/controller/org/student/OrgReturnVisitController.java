package com.alonelaval.cornerstone.web.controller.org.student;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.OrgReturnVisit;
import com.alonelaval.cornerstone.entity.model.OrgReturnVisitModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.student.OrgReturnVisitService;
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
@RequestMapping("org/visit")
public class OrgReturnVisitController extends AbstractController {

    @Autowired
    OrgReturnVisitService orgReturnVisitService;

    @PostMapping("add")
    public Object add(@Validated OrgReturnVisitModel orgReturnVisitModel) throws Exception {
       return  super.addBasic(orgReturnVisitModel);
    }

    @PostMapping("update")
    public Object update(@Validated OrgReturnVisitModel orgReturnVisitModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orgReturnVisitModel,id);
    }

    @PostMapping("list")
    public Object list(OrgReturnVisitModel model, Page<OrgReturnVisit> page) throws Exception {
        return  super.listBasic(model,page);
    }

    @PostMapping("/disable")

    @Validated
    public Object disable(@NotNull(message = "ID不能为空!")  Integer ... ids)throws  Exception{
        return  super.disableBasic(ids);
    }
    @PostMapping("/enable")

    @Validated
    public Object enable(@NotNull(message = "ID不能为空!")  Integer ... ids)throws  Exception{
        return  super.enableBasic(ids);
    }
    @PostMapping("/delete")

    @Validated
    public Object delete(@NotNull(message = "ID不能为空!")  Integer ... ids)throws  Exception{
        return  super.deleteBasic(ids);
    }

    @Override
    protected IBaseService getBaseService() {
        return orgReturnVisitService;
    }

}
