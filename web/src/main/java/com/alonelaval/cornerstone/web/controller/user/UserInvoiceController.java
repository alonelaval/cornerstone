package com.alonelaval.cornerstone.web.controller.user;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.UserInvoice;
import com.alonelaval.cornerstone.entity.model.InvoiceModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.user.UserInvoiceService;
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
@RequestMapping("user/invoice")
@Validated
public class UserInvoiceController extends AbstractController {

    @Autowired
    UserInvoiceService userInvoiceService;

    @PostMapping("add")
    public Object addInvoice(@Validated InvoiceModel invoiceModel) throws Exception {
       return  super.addBasic(invoiceModel);
    }

    @PostMapping("update")
    public Object update(@Validated InvoiceModel invoiceModel,@NotNull(message = "ID不能为空！") Integer invoiceId) throws Exception {
        return  super.updateBasic(invoiceModel,invoiceId);
    }
    @PostMapping("findAllByUserId")
    public Object findAllByUserId(@NotNull(message = "ID不能为空！") Integer userId) throws Exception {
        return  responseData(userInvoiceService.findInvoicesByUserId(userId));
    }

    @PostMapping("list")
    public Object list(InvoiceModel model, Page<UserInvoice> page) throws Exception {
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
        return userInvoiceService;
    }

}
