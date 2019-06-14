package com.alonelaval.cornerstone.web.controller.platform;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.entity.biz.PlatformShopkeeper;
import com.alonelaval.cornerstone.entity.model.PlatformShopkeeperModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.platform.PlatformShopkeeperService;
import com.alonelaval.cornerstone.web.config.ApplicationConfig;
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
@RequestMapping("platform/shopkeeper")
public class PlatformShopkeeperController extends AbstractController {

    @Autowired
    PlatformShopkeeperService platformShopkeeperService;
    @Autowired
    ApplicationConfig config;

    @PostMapping("add")
    public Object add(@Validated PlatformShopkeeperModel platformShopkeeperModel) throws Exception {
       return  super.addBasic(platformShopkeeperModel);
    }




    @PostMapping("update")
    public Object update(@Validated PlatformShopkeeperModel platformShopkeeperModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(platformShopkeeperModel,id);
    }

    @PostMapping("list")
    public Object list(PlatformShopkeeperModel model, Page<PlatformShopkeeper> page) throws Exception {
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
        return platformShopkeeperService;
    }

}
