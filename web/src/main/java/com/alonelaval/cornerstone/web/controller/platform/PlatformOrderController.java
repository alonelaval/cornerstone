package com.alonelaval.cornerstone.web.controller.platform;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.PlatformOrder;
import com.alonelaval.cornerstone.entity.model.PlatformOrderModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.platform.PlatformOrderService;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author huawei
 * @create 2018-07-29
 **/
@Controller
@RequestMapping("platform/order")
@Validated
public class PlatformOrderController extends AbstractController {

    @Autowired
    PlatformOrderService platformOrderService;

    @PostMapping("add")
    public Object add(@Validated PlatformOrderModel platformOrderModel) throws Exception {
       return  super.addBasic(platformOrderModel);
    }

    @PostMapping("update")
    public Object update(@Validated PlatformOrderModel platformOrderModel,@Validated @Valid  @NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(platformOrderModel,id);
    }

    @PostMapping("invoice")
    public Object invoice(@RequestParam("orderIds") List<Integer> orderIds,
                          @NotNull(message = "ID不能为空！") Integer invoiceId,
                          @NotNull(message = "ID不能为空！") Integer addresseeId) throws Exception {
        platformOrderService.invoicePlatformOrder(orderIds,invoiceId,addresseeId);
        return  super.responseBasic();
    }

    @PostMapping("list")
    public Object list(PlatformOrderModel model, Page<PlatformOrder> page) throws Exception {
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
        return platformOrderService;
    }

}
