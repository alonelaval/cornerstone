package com.alonelaval.cornerstone.web.controller.org.classes;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.base.JsonResult;
import com.alonelaval.cornerstone.entity.biz.OrgClassCoach;
import com.alonelaval.cornerstone.entity.model.OrgClassCoachModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.classes.OrgClassCoachService;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author huawei
 * @create 2018-07-29
 **/
@Controller
@RequestMapping("org/class/coach")
public class OrgClassCoachController extends AbstractController {

    @Autowired
    OrgClassCoachService orgClassCoachService;

    @PostMapping("add")
    public Object add(@Validated OrgClassCoachModel orgClassCoachModel) throws Exception {
       return  super.addBasic(orgClassCoachModel);
    }

    @PostMapping("update")
    public Object update(@Validated OrgClassCoachModel orgClassCoachModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orgClassCoachModel,id);
    }

    @PostMapping("list")
    public Object list(OrgClassCoachModel model, Page<OrgClassCoach> page) throws Exception {
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
    @PostMapping("/addOrgCoach")
    public Object addOrgCoach(Integer classId,@NotNull(message = "ID不能为空!") @RequestParam("employeIds") List<Integer> employeIds)throws  Exception{
        return ResponseEntity.ok().body(JsonResult.builder().data(orgClassCoachService.addOrgCoachs(classId,employeIds))
                .build());
    }

    @Override
    protected IBaseService getBaseService() {
        return orgClassCoachService;
    }

}
