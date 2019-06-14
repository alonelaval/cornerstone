package com.alonelaval.cornerstone.web.exception;

import com.alibaba.fastjson.JSONObject;
import com.alonelaval.cornerstone.entity.base.JsonResult;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

/**
 * @author huawei
 * @create 2018-07-26
 **/
//@Component
@Deprecated
@Slf4j
public class YczResponseExceptionResolver extends DefaultHandlerExceptionResolver {


    @Override
    protected ModelAndView handleBindException(BindException ex, HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        String message =ex.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect( Collectors.joining( "," ) );
        handlerException(request,response,JsonResult.builder().message(message).resultCode(ExceptionType.PARAM_ERROR.value()).build());
        log.error(request.getRequestURI()+ "："+ message);
        return new ModelAndView();
//        return super.handleBindException(ex, request, response, handler);
    }

    private void handlerException(HttpServletRequest request, HttpServletResponse response, JsonResult jsonResult) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String s = JSONObject.toJSON(jsonResult).toString();
        out.write(s);
        out.flush();
        out.close();
    }
}
