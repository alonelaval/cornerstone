package com.alonelaval.cornerstone.web.controller.user;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.entity.biz.OrderInvoiceRecord;
import com.alonelaval.cornerstone.entity.model.OrderInvoiceRecordModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.user.OrderInvoiceRecordService;
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
@RequestMapping("invoice")
public class OrderInvoiceRecordController extends AbstractController {

    @Autowired
    OrderInvoiceRecordService orderInvoiceRecordService;

    @PostMapping("add")
    public Object add(@Validated OrderInvoiceRecordModel orderInvoiceRecordModel) throws Exception {
       return  super.addBasic(orderInvoiceRecordModel);
    }

    @PostMapping("update")
    public Object update(@Validated OrderInvoiceRecordModel orderInvoiceRecordModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orderInvoiceRecordModel,id);
    }

    @PostMapping("list")
    public Object list(OrderInvoiceRecordModel model, Page<OrderInvoiceRecord> page) throws Exception {
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
        return orderInvoiceRecordService;
    }

}
