package com.alonelaval.cornerstone.web.controller.user;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.UserStudent;
import com.alonelaval.cornerstone.entity.model.UserStudentModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.user.UserStudentService;
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
@RequestMapping("user/student")
public class UserStudentController extends AbstractController {

    @Autowired
    UserStudentService userStudentService;

    @PostMapping("add")
    public Object add(@Validated UserStudentModel userStudentModel) throws Exception {
       return  super.addBasic(userStudentModel);
    }

    @PostMapping("update")
    public Object update(@Validated UserStudentModel userStudentModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(userStudentModel,id);
    }

    @PostMapping("list")
    public Object list(UserStudentModel model, Page<UserStudent> page) throws Exception {
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
        return userStudentService;
    }

}
