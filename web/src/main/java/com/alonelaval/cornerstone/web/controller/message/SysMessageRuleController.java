package com.alonelaval.cornerstone.web.controller.message;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.SysMessageRule;
import com.alonelaval.cornerstone.entity.constants.AuditState;
import com.alonelaval.cornerstone.entity.model.SysMessageRuleModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.message.SysMessageRuleService;
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
@RequestMapping("sys/message/rule")
public class SysMessageRuleController extends AbstractController {

    @Autowired
    SysMessageRuleService sysMessageRuleService;


    @PostMapping("auditRule")
    public Object auditRule(@NotNull(message = "ID不能为空！") Integer ruleId, AuditState auditState) throws Exception {
        return  super.responseData(sysMessageRuleService.auditRule(ruleId,auditState));
    }

    @PostMapping("add")
    public Object add(@Validated SysMessageRuleModel sysMessageRuleModel) throws Exception {
       return  super.addBasic(sysMessageRuleModel);
    }

    @PostMapping("update")
    public Object update(@Validated SysMessageRuleModel sysMessageRuleModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(sysMessageRuleModel,id);
    }

    @PostMapping("list")
    public Object list(SysMessageRuleModel model, Page<SysMessageRule> page) throws Exception {
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
        return sysMessageRuleService;
    }

}
