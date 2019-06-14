package com.alonelaval.cornerstone.web.controller.org.order;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.entity.biz.OrgOrder;
import com.alonelaval.cornerstone.entity.model.OrgOrderModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.order.OrgOrderService;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author huawei
 * @create 2018-07-29
 **/
@Controller
@RequestMapping("org/order")
public class OrgOrderController extends AbstractController {

    @Autowired
    OrgOrderService orgOrderService;

    @PostMapping("invoice")
    public Object invoice(@RequestParam("orderIds") List<Integer> orderIds,
                          @NotNull(message = "ID不能为空！") Integer invoiceId,
                          @NotNull(message = "ID不能为空！") Integer addresseeId) throws Exception {
        orgOrderService.invoiceOrder(orderIds,invoiceId,addresseeId);
        return  super.responseBasic();
    }


    @PostMapping("add")
    public Object add(@Validated OrgOrderModel orgOrderModel) throws Exception {
       return  super.addBasic(orgOrderModel);
    }

    @PostMapping("update")
    public Object update(@Validated OrgOrderModel orgOrderModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orgOrderModel,id);
    }

    @PostMapping("list")
    public Object list(OrgOrderModel model, Page<OrgOrder> page) throws Exception {
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
        return orgOrderService;
    }

}
