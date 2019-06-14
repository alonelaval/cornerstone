package com.alonelaval.cornerstone.web.controller.platform;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.Role;
import com.alonelaval.cornerstone.entity.model.RoleModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.platform.RoleService;
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
@RequestMapping("platform/role")
public class RoleController extends AbstractController {

    @Autowired
    RoleService roleService;


    @PostMapping("addOrgRole")

    public Object addOrgRole(@Validated RoleModel roleModel) throws Exception {
        return  responseData(roleService.addOrgRole(roleModel));
    }
    @PostMapping("addPlatformRole")
    public Object addPlatformRole(@Validated RoleModel roleModel) throws Exception {
        return  responseData(roleService.addPlatformRole(roleModel));
    }

    @PostMapping("add")
    public Object add(@Validated RoleModel roleModel) throws Exception {
       return  super.addBasic(roleModel);
    }

    @PostMapping("update")
    public Object update(@Validated RoleModel roleModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(roleModel,id);
    }

    @PostMapping("list")
    public Object list(RoleModel model, Page<Role> page) throws Exception {
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
    @Validated
    public Object delete(@NotNull(message = "ID不能为空!")  Integer ... ids)throws  Exception{
        return  super.deleteBasic(ids);
    }

    @Override
    protected IBaseService getBaseService() {
        return roleService;
    }

}
