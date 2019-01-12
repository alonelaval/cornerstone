package com.alonelaval.cornerstone.web.controller.platform;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.base.JsonResult;
import com.alonelaval.cornerstone.entity.biz.RolePermission;
import com.alonelaval.cornerstone.entity.model.RolePermissionModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.platform.RolePermissionService;
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
@RequestMapping("platform/role/permission")
@Validated
public class RolePermissionController extends AbstractController {

    @Autowired
    RolePermissionService rolePermissionService;

    @PostMapping("addRoleSysPermissions")
    @Validated
    public Object addRoleSysPermissions( @RequestParam("permissions") @NotNull(message = "权限ID不能为空！")List<Integer> permissions,
                                         @NotNull(message = "角色ID不能为空！")Integer roleId) throws Exception {

        return ResponseEntity.ok().body(JsonResult.builder().data( rolePermissionService.addRoleSysPermissions(permissions,roleId)).build());
    }

    @PostMapping("addRoleOrgPermissions")
    public Object addRoleOrgPermissions(  @RequestParam("opIds") @NotNull(message = "权限ID不能为空！")List<Integer> opIds,  @NotNull(message = "角色ID不能为空！")Integer roleId) throws Exception {
        return ResponseEntity.ok().body(JsonResult.builder().data( rolePermissionService.addRoleOrgPermissions(opIds,roleId)).build());
    }

    @PostMapping("update")
    public Object update(@Validated RolePermissionModel rolePermissionModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(rolePermissionModel,id);
    }

    @PostMapping("list")
    public Object list(RolePermissionModel model, Page<RolePermission> page) throws Exception {
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
        return rolePermissionService;
    }

}
