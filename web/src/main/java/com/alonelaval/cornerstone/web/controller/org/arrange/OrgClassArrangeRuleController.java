package com.alonelaval.cornerstone.web.controller.org.arrange;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.OrgClassArrangeRule;
import com.alonelaval.cornerstone.entity.model.OrgClassArrangeRuleModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.arrange.OrgClassArrangeRuleService;
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
@RequestMapping("org/arrange")
public class OrgClassArrangeRuleController extends AbstractController {

    @Autowired
    OrgClassArrangeRuleService orgClassArrangeRuleService;

    @PostMapping("add")
    public Object add(@Validated OrgClassArrangeRuleModel orgArrangeRuleModel) throws Exception {
       return  super.addBasic(orgArrangeRuleModel);
    }

    @PostMapping("update")
    public Object update(@Validated OrgClassArrangeRuleModel orgArrangeRuleModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orgArrangeRuleModel,id);
    }

    @PostMapping("list")
    public Object list(OrgClassArrangeRuleModel model, Page<OrgClassArrangeRule> page) throws Exception {
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
        return orgClassArrangeRuleService;
    }

}
