package com.alonelaval.cornerstone.web.controller.platform;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.SecretKey;
import com.alonelaval.cornerstone.entity.model.SecretKeyModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.platform.SecretKeyService;
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
@RequestMapping("platform/secret")
public class SecretKeyController extends AbstractController {

    @Autowired
    SecretKeyService secretKeyService;

    @PostMapping("add")
    public Object add(@Validated SecretKeyModel secretKeyModel) throws Exception {
       return  super.addBasic(secretKeyModel);
    }

    @PostMapping("update")
    public Object update(@Validated SecretKeyModel secretKeyModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(secretKeyModel,id);
    }

    @PostMapping("list")
    public Object list(SecretKeyModel model, Page<SecretKey> page) throws Exception {
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
        return secretKeyService;
    }

}
