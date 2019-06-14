package com.alonelaval.cornerstone.service.platform.message;

import com.alonelaval.cornerstone.entity.constants.PlatformMessageType;

/**
 * @author huawei
 * @create 2018-07-21
 **/
public interface SmsMessageService {
    /**
     * test
     * @return
     * @throws Exception
     */
    String createSmsCode()throws Exception;

    /***
     * 发送短信
     * @param phone
     * @param message
     * @throws Exception
     */
    void sendSmsMessage(String phone,String message)throws  Exception;

    /***
     * 发送用户验证码短信，密码找回，注册等
     * @param phone
     * @throws Exception
     */
    void sendUserSmsCodeMessage(String phone, PlatformMessageType platformMessageType)throws  Exception;

    /**
     * 验证短信
     * @param phone
     * @param code
     * @return
     * @throws Exception
     */
    boolean verificationCode(String phone,String code) throws  Exception;
}
