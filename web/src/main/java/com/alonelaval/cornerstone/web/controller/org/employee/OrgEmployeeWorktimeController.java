package com.alonelaval.cornerstone.web.controller.org.employee;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeWorktime;
import com.alonelaval.cornerstone.entity.model.OrgEmployeeWorktimeModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeWorktimeService;
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
@RequestMapping("org/employee/worktime")
public class OrgEmployeeWorktimeController extends AbstractController {

    @Autowired
    OrgEmployeeWorktimeService orgEmployeeWorktimeService;

    @PostMapping("add")
    public Object add(@Validated OrgEmployeeWorktimeModel orgEmployeeWorktimeModel) throws Exception {
       return  super.addBasic(orgEmployeeWorktimeModel);
    }

    @PostMapping("update")
    public Object update(@Validated OrgEmployeeWorktimeModel orgEmployeeWorktimeModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orgEmployeeWorktimeModel,id);
    }

    @PostMapping("list")
    public Object list(OrgEmployeeWorktimeModel model, Page<OrgEmployeeWorktime> page) throws Exception {
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


    protected IBaseService getBaseService() {
        return orgEmployeeWorktimeService;
    }

}
