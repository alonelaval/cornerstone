package com.alonelaval.cornerstone.web.controller.user;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.UserAddressee;
import com.alonelaval.cornerstone.entity.model.OrgOrderModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.order.OrgOrderService;
import com.alonelaval.cornerstone.web.config.ApplicationConfig;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huawei
 * @create 2018-07-15
 **/
@Controller
@RequestMapping("user/order")
@Slf4j
@Validated
public class UserOrderContorller extends AbstractController {
    @Autowired
    OrgOrderService orgOrderService;
    @Autowired
    ApplicationConfig config;

    @PostMapping("list")
    public Object list(OrgOrderModel model, Page<UserAddressee> page) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        model.setUserId(userAdapter.getUser().getUserId());
        return  super.listBasic(model,page);
    }




    @Override
    protected IBaseService getBaseService() {
        return orgOrderService;
    }
}
