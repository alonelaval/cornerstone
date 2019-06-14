package com.alonelaval.cornerstone.web.controller.org.promotion;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.OrgPromotionCondition;
import com.alonelaval.cornerstone.entity.model.OrgPromotionConditionModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.promotion.OrgPromotionConditionService;
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
@RequestMapping("org/promotion/condition")
public class OrgPromotionConditionController extends AbstractController {

    @Autowired
    OrgPromotionConditionService orgPromotionConditionService;

    @PostMapping("add")
    public Object add(@Validated OrgPromotionConditionModel orgPromotionConditionModel) throws Exception {
       return  super.addBasic(orgPromotionConditionModel);
    }

    @PostMapping("update")
    public Object update(@Validated OrgPromotionConditionModel orgPromotionConditionModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orgPromotionConditionModel,id);
    }

    @PostMapping("list")
    public Object list(OrgPromotionConditionModel model, Page<OrgPromotionCondition> page) throws Exception {
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
        return orgPromotionConditionService;
    }

}
