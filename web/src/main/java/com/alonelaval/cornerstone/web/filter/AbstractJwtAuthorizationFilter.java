package com.alonelaval.cornerstone.web.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.cornerstone.entity.base.JsonResult;
import org.springframework.security.core.Authentication;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author huawei
 * @create 2018-07-17
 **/
public abstract class AbstractJwtAuthorizationFilter extends OncePerRequestFilter {

    private FastJsonConfig fastJsonConfig;

    public AbstractJwtAuthorizationFilter(FastJsonConfig fastJsonConfig){
        this.fastJsonConfig =fastJsonConfig;
    }

    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, JsonResult jsonResult) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(jsonResult,fastJsonConfig.getSerializeFilters(),fastJsonConfig.getSerializerFeatures()));
        out.flush();
        out.close();
    }

    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,JsonResult jsonResult) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(jsonResult,fastJsonConfig.getSerializeFilters(),fastJsonConfig.getSerializerFeatures()));
        out.flush();
        out.close();
    }

    protected boolean isLogin(Authentication auth){
        return !UserContextHolder.getInstance().isAnonymous();
//        if(auth != null && !(auth instanceof AnonymousAuthenticationToken))
//        {
//            return  true;
//        }
//        return false;
    }

}
