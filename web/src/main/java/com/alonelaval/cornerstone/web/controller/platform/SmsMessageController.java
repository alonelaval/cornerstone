package com.alonelaval.cornerstone.web.controller.platform;

import com.alonelaval.cornerstone.entity.base.JsonResult;
import com.alonelaval.cornerstone.entity.constants.PlatformMessageType;
import com.alonelaval.cornerstone.service.platform.message.SmsMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author huawei
 * @create 2018-07-21
 **/
@Controller()
@RequestMapping("platform/message")
public class SmsMessageController {

    @Autowired
    SmsMessageService smsMessageService;

    @RequestMapping("/create")
    @ResponseBody
    public Object createCode() throws Exception {
        return JsonResult.builder().data(smsMessageService.createSmsCode()).build();
    }
    @RequestMapping("/sendMessage")
    @ResponseBody
    @Validated
    public Object sendMessage(@NotBlank(message = "手机号不能为空！") @Pattern(regexp = "1[3|4|5|7|8][0-9]\\d{8}",message ="手机号码格式错误！") String phone, Integer  messageType) throws Exception {
        PlatformMessageType platformMessageType = messageType == null ? PlatformMessageType.USER_REG : PlatformMessageType.valueOf(messageType);
        smsMessageService.sendUserSmsCodeMessage(phone,platformMessageType);
        return JsonResult.builder().build();
    }


}
