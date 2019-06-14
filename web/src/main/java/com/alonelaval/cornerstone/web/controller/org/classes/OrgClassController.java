package com.alonelaval.cornerstone.web.controller.org.classes;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.base.JsonResult;
import com.alonelaval.cornerstone.entity.biz.OrgClass;
import com.alonelaval.cornerstone.entity.model.OrgClassModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.classes.OrgClassService;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("org/class")
public class OrgClassController extends AbstractController {

    @Autowired
    OrgClassService orgClassService;

    @PostMapping("add")
    public Object add(@Validated OrgClassModel orgClassModel) throws Exception {
       return  super.addBasic(orgClassModel);
    }

    @PostMapping("changeMainCoach")
    public Object updateMainCoach(@Validated OrgClassModel orgClassModel) throws Exception {
        return  ResponseEntity.ok().body(JsonResult.builder().data(orgClassService.changeMainCoach(orgClassModel)).build());
    }

    @PostMapping("update")
    public Object update(@Validated OrgClassModel orgClassModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orgClassModel,id);
    }

    @PostMapping("list")
    public Object list(OrgClassModel model, Page<OrgClass> page) throws Exception {
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
        return orgClassService;
    }

}
