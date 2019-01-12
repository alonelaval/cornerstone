package com.alonelaval.cornerstone.web.exception;

import com.alibaba.fastjson.JSONObject;
import com.alonelaval.common.exception.DaoException;
import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.cornerstone.entity.base.JsonResult;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

/**
 * @author huawei
 * @create 2018-07-21
 **/
//@Component
@Slf4j
public class RestResponseStatusExceptionResolver extends AbstractHandlerExceptionResolver {
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex) {
        try {
            if(ex instanceof ServiceException){
                ServiceException exception = (ServiceException) ex;
                    handlerException(request,response,JsonResult.builder().message(ex.getMessage())
                            .resultCode(exception.getErrorCode()).build());

            }
            else if(ex instanceof DaoException){
                handlerException(request,response,JsonResult.builder().message(ex.getMessage())
                        .resultCode(ExceptionType.DAO_EXCEPTION.value()).build());
            }
            else if(ex instanceof ConstraintViolationException){
                ConstraintViolationException constraintViolationException = (ConstraintViolationException) ex;
                String message =constraintViolationException.getConstraintViolations().stream().map(cv ->cv.getMessage() ).collect( Collectors.joining( "," ) );
                handlerException(request,response,JsonResult.builder().message(message).resultCode(ExceptionType.PARAM_ERROR.value()).build());
            }
            if(ex instanceof BindException){
                BindException bindException = (BindException)ex;
                String message =bindException.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect( Collectors.joining( "," ) );
                handlerException(request,response,JsonResult.builder().message(message).resultCode(ExceptionType.PARAM_ERROR.value()).build());
//                log.error(request.getRequestURI()+ " ："+ message,bindException);
//                return new ModelAndView();
            }
            else {
                handlerException(request,response,JsonResult.builder().message(ex.getMessage())
                        .resultCode(ExceptionType.UNKNOWN_ERROR.value()).build());
            }

            log.error(ex.getMessage(),ex);
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }
        return new ModelAndView();
    }
    private void handlerException(HttpServletRequest request, HttpServletResponse response,JsonResult jsonResult) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String s = JSONObject.toJSON(jsonResult).toString();
        out.write(s);
        out.flush();
        out.close();
    }
}
