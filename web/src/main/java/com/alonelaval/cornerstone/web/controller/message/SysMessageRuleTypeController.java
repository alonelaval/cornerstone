package com.alonelaval.cornerstone.web.controller.message;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.SysMessageRuleType;
import com.alonelaval.cornerstone.entity.model.SysMessageRuleTypeModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.message.SysMessageRuleTypeService;
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
@RequestMapping("org/message/rule/type")
public class SysMessageRuleTypeController extends AbstractController {

    @Autowired
    SysMessageRuleTypeService sysMessageRuleTypeService;

    @PostMapping("add")
    public Object add(@Validated SysMessageRuleTypeModel sysMessageRuleTypeModel) throws Exception {
       return  super.addBasic(sysMessageRuleTypeModel);
    }

    @PostMapping("update")
    public Object update(@Validated SysMessageRuleTypeModel sysMessageRuleTypeModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(sysMessageRuleTypeModel,id);
    }

    @PostMapping("list")
    public Object list(SysMessageRuleTypeModel model, Page<SysMessageRuleType> page) throws Exception {
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
        return sysMessageRuleTypeService;
    }

}
