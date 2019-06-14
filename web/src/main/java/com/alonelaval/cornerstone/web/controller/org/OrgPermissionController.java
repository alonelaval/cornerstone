package com.alonelaval.cornerstone.web.controller.org;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.entity.biz.OrgPermission;
import com.alonelaval.cornerstone.entity.model.OrgPermissionModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.OrgPermissionService;
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
@RequestMapping("org/permission")
public class OrgPermissionController extends AbstractController {

    @Autowired
    OrgPermissionService orgPermissionService;

    @PostMapping("add")
    public Object add(@Validated OrgPermissionModel orgPermissionModel) throws Exception {
       return  super.addBasic(orgPermissionModel);
    }

    @PostMapping("update")
    public Object update(@Validated OrgPermissionModel orgPermissionModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orgPermissionModel,id);
    }

    @PostMapping("list")
    public Object list(OrgPermissionModel model, Page<OrgPermission> page) throws Exception {
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
        return orgPermissionService;
    }

}
