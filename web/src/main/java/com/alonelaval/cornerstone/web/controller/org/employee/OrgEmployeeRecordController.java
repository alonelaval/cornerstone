package com.alonelaval.cornerstone.web.controller.org.employee;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.OrgEmployeeRecord;
import com.alonelaval.cornerstone.entity.model.OrgEmployeeRecordModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeRecordService;
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
@RequestMapping("org/employee/record")
public class OrgEmployeeRecordController extends AbstractController {

    @Autowired
    OrgEmployeeRecordService orgEmployeeRecordService;

    @PostMapping("add")
    public Object add(@Validated OrgEmployeeRecordModel orgEmployeeRecordModel) throws Exception {
       return  super.addBasic(orgEmployeeRecordModel);
    }

    @PostMapping("update")
    public Object update(@Validated OrgEmployeeRecordModel orgEmployeeRecordModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orgEmployeeRecordModel,id);
    }

    @PostMapping("list")
    public Object list(OrgEmployeeRecordModel model, Page<OrgEmployeeRecord> page) throws Exception {
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
        return orgEmployeeRecordService;
    }

}
