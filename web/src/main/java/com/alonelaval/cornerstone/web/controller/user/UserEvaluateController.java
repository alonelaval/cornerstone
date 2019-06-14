package com.alonelaval.cornerstone.web.controller.user;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.UserEvaluate;
import com.alonelaval.cornerstone.entity.model.UserEvaluateModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.user.UserEvaluateService;
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
@RequestMapping("user/evaluate")
public class UserEvaluateController extends AbstractController {

    @Autowired
    UserEvaluateService userEvaluateService;

    @PostMapping("add")
    public Object add(@Validated UserEvaluateModel userEvaluateModel) throws Exception {
       return  super.addBasic(userEvaluateModel);
    }

    @PostMapping("update")
    public Object update(@Validated UserEvaluateModel userEvaluateModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(userEvaluateModel,id);
    }

    @PostMapping("list")
    public Object list(UserEvaluateModel model, Page<UserEvaluate> page) throws Exception {
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
        return userEvaluateService;
    }

}
