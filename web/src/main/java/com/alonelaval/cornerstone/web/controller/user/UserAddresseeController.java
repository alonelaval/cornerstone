package com.alonelaval.cornerstone.web.controller.user;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.base.JsonResult;
import com.alonelaval.cornerstone.entity.biz.UserAddressee;
import com.alonelaval.cornerstone.entity.model.UserAddresseeModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.user.UserAddresseeService;
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
 * 收货地址
 **/
@Controller
@RequestMapping("user/addressee")
@Validated
public class UserAddresseeController extends AbstractController {

    @Autowired
    UserAddresseeService userAddresseeService;

    @PostMapping("add")
    public Object add(@Validated UserAddresseeModel userAddresseeModel) throws Exception {
       return  ResponseEntity.ok().body(JsonResult.builder().data(userAddresseeService.addUserAddress(userAddresseeModel)).build());
    }

    @PostMapping("update")
    public Object update(@Validated UserAddresseeModel userAddresseeModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(userAddresseeModel,id);
    }
    @PostMapping("findAllByUserId")
    public Object findAllByUserId(@NotNull(message = "ID不能为空！") Integer userId) throws Exception {
        return  responseData(userAddresseeService.findAllByUserId(userId));
    }


    @PostMapping("list")
    public Object list(UserAddresseeModel model, Page<UserAddressee> page) throws Exception {
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
        return userAddresseeService;
    }

}
