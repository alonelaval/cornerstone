package com.alonelaval.cornerstone.web.controller.org.classes;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.base.JsonResult;
import com.alonelaval.cornerstone.entity.biz.OrgClassStudent;
import com.alonelaval.cornerstone.entity.model.OrgClassStudentModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.classes.OrgClassStudentService;
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
@RequestMapping("org/class/student")
public class OrgClassStudentController extends AbstractController {

    @Autowired
    OrgClassStudentService orgClassStudentService;

    @PostMapping("add")
    public Object add(@Validated OrgClassStudentModel orgClassStudentModel) throws Exception {
       return  super.addBasic(orgClassStudentModel);
    }

    @PostMapping("update")
    public Object update(@Validated OrgClassStudentModel orgClassStudentModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orgClassStudentModel,id);
    }

    @PostMapping("list")
    public Object list(OrgClassStudentModel model, Page<OrgClassStudent> page) throws Exception {
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

    @PostMapping("/addStudent")
    public Object addOrgStudent(Integer classId,@NotNull(message = "ID不能为空!") @RequestParam("orgStudentIds") List<Integer> orgStudentIds)throws  Exception{
        return ResponseEntity.ok().body(JsonResult.builder().data(orgClassStudentService.addOrgStudents(classId,orgStudentIds))
                .build());
    }

    @Override
    protected IBaseService getBaseService() {
        return orgClassStudentService;
    }

}
