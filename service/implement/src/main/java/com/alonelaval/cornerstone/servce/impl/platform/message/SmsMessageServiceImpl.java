package com.alonelaval.cornerstone.servce.impl.platform.message;

import com.alonelaval.common.message.SmsCodeGenerator;
import com.alonelaval.cornerstone.cache.SmsCodeMessageCache;
import com.alonelaval.cornerstone.entity.constants.PlatformMessageType;
import com.alonelaval.cornerstone.service.platform.message.SmsMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author huawei
 * @create 2018-07-21
 **/
@Service("smsMessageService")
@Slf4j
@Transactional(rollbackFor = Exception.class)

public class SmsMessageServiceImpl implements SmsMessageService {
    @Override
    public String createSmsCode() throws Exception {
//        throw  new ServiceException(ExceptionType.UNKNOWN_ERROR.value(),ExceptionType.UNKNOWN_ERROR.desc());
        return SmsCodeGenerator.generateCode();
    }

    @Override
    public void sendSmsMessage(String phone, String message) throws Exception {

    }

    @Override
    public void sendUserSmsCodeMessage(String phone, PlatformMessageType platformMessageType) throws Exception {
        String code = createSmsCode();

        log.info("手机号：{} , 注册验证码为：{}",phone,code);
        SmsCodeMessageCache.getInstance().put(phone,code);
        // TODO: 2018/7/21  真实的发送短信
        this.sendSmsMessage(phone,code);
    }

    @Override
    public boolean verificationCode(String phone, String code) throws Exception {
        boolean verity = SmsCodeMessageCache.getInstance().verificationCode(phone,code);
        if(verity){
            SmsCodeMessageCache.getInstance().invalidate(phone);
        }

        return verity;

    }

}
