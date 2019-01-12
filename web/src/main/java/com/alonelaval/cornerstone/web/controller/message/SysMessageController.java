package com.alonelaval.cornerstone.web.controller.message;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.SysMessage;
import com.alonelaval.cornerstone.entity.model.SysMessageModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.message.SysMessageService;
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
@RequestMapping("sys/message")
public class SysMessageController extends AbstractController {

    @Autowired
    SysMessageService sysMessageService;

    @PostMapping("add")
    public Object add(@Validated SysMessageModel sysMessageModel) throws Exception {
       return  super.addBasic(sysMessageModel);
    }

    @PostMapping("update")
    public Object update(@Validated SysMessageModel sysMessageModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(sysMessageModel,id);
    }

    @PostMapping("list")
    public Object list(SysMessageModel model, Page<SysMessage> page) throws Exception {
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
        return sysMessageService;
    }

}
