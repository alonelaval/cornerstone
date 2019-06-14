package com.alonelaval.common.security;

import lombok.extern.slf4j.Slf4j;

/**
 * @author huawei
 * @create 2018-07-22
 **/
@Slf4j
public class IDSecurityUtils {

    public static String encId(String id,String key){
        try {
            if(null == id)
            {
                return id;
            }
            return  CryptoUtils.encDES(id.toString(),key.getBytes());
        } catch (Exception e) {
            log.error("加密id出错！",e);
        }
        return  null;
    }

    public static String decId(String id,String key){
        try {
            if(null == id)
            {
                return id;
            }
            return new String(CryptoUtils.decDES(id,key.getBytes()));
        } catch (Exception e) {
            log.error("加密id出错！",e);
        }
        return  null;
    }

    public static void main(String[] args) {
        String id = "21";
        String securityKeyForId="12345678";

        String encId = encId(id.toString(),securityKeyForId);
        System.out.println(encId);
        String decId = decId(encId,securityKeyForId);

        System.out.println(decId);

    }
}
