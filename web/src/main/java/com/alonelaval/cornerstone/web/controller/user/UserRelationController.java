package com.alonelaval.cornerstone.web.controller.user;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.UserRelation;
import com.alonelaval.cornerstone.entity.model.UserRelationModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.user.UserRelationService;
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
@RequestMapping("user/relation")
public class UserRelationController extends AbstractController {

    @Autowired
    UserRelationService userRelationService;

    @PostMapping("add")
    public Object add(@Validated UserRelationModel userRelationModel) throws Exception {
       return  super.addBasic(userRelationModel);
    }

    @PostMapping("update")
    public Object update(@Validated UserRelationModel userRelationModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(userRelationModel,id);
    }

    @PostMapping("list")
    public Object list(UserRelationModel model, Page<UserRelation> page) throws Exception {
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
        return userRelationService;
    }

}
