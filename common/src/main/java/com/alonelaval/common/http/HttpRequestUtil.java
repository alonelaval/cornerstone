package com.alonelaval.common.http;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huawei
 * @create 2018-11-17
 **/
public class HttpRequestUtil
{
    public static final String getRequestUri(HttpServletRequest request){
        String requestUri = request.getHeader("X-Forwarded-Uri");
        if ( requestUri != null )
        {
            requestUri = requestUri.replace(request.getContextPath(), "");
        }
        else
        {
            requestUri = request.getRequestURI();
            requestUri = requestUri.replace(request.getContextPath(), "");
        }
        return requestUri;
    }

    public static String getIp(HttpServletRequest request)
    {
        String ip = request.getHeader("X-Real-IP");
        if (null != ip && !"".equals(ip.trim()) && !"unknown".equalsIgnoreCase(ip))
        {
            return ip;
        }

        ip = request.getHeader("X-Forwarded-For");
        if (null != ip && !"".equals(ip.trim()) && !"unknown".equalsIgnoreCase(ip))
        {
            // get first ip from proxy ip
            int index = ip.indexOf(',');
            if (index != -1)
            {
                return ip.substring(0, index);
            }
            else
            {
                return ip;
            }
        }

        return request.getRemoteAddr();

    }
}
