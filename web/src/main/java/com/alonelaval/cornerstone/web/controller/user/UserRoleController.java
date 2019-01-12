package com.alonelaval.cornerstone.web.controller.user;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.base.JsonResult;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.biz.PlatformShopkeeper;
import com.alonelaval.cornerstone.entity.biz.UserRole;
import com.alonelaval.cornerstone.entity.model.UserRoleModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.user.UserRoleService;
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
@RequestMapping("user/role")
public class UserRoleController extends AbstractController {

    @Autowired
    UserRoleService userRoleService;

    @PostMapping("addOrgEmployeeRole")
    @Validated
    public Object addOrgEmployeeRole( @NotNull(message = "角色不能为空！") @RequestParam(value="roleIds")  List<Integer> roleIds,
                                      @NotNull(message = "员工信息不能为空！") OrgEmployee orgEmployees) throws Exception {
        return ResponseEntity.ok().body(JsonResult.builder().data(userRoleService.addOrgEmployeeRole(roleIds,orgEmployees)).build());
    }

    @PostMapping("addPlatformShopkeeperRole")
    @Validated
    public Object addOrgEmployeeRole(@NotNull(message = "角色不能为空！") @RequestParam(value="roleIds") List<Integer> roleIds, @NotNull(message = "店主信息不能为空！")
            PlatformShopkeeper platformShopkeeper) throws Exception {
        return ResponseEntity.ok().body(JsonResult.builder().data(userRoleService.addPlatformShopkeeperRole(roleIds,platformShopkeeper)).build());
    }

    @PostMapping("list")
    public Object list(UserRoleModel model, Page<UserRole> page) throws Exception {
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
        return userRoleService;
    }

}
