package com.alonelaval.cornerstone.web.common;

import com.alonelaval.common.security.IDSecurityUtils;
import com.alonelaval.cornerstone.web.config.ApplicationConfig;
import com.alonelaval.cornerstone.web.config.ApplicationConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huawei
 * @create 2018-07-22
 * @deprecated 直接使用converter
 **/
public class IDSecurityArgumentResolver implements HandlerMethodArgumentResolver {

    private ApplicationConfig applicationConfig;

    public IDSecurityArgumentResolver(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(IDSecurity.class) != null;
    }

    @Override
    public Object resolveArgument(
            MethodParameter methodParameter,
            ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest,
            WebDataBinderFactory webDataBinderFactory) throws Exception {

        HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();

        String paramName = methodParameter.getParameterName();

        String value = request.getParameter(paramName);
        if(StringUtils.isBlank(value)) {
            return null;
        }
        Integer id = Integer.parseInt(IDSecurityUtils.decId(value,applicationConfig.getIdSecret()));

        return id;
    }
}
/***
     @Override
     public void addArgumentResolvers(
       List<HandlerMethodArgumentResolver> argumentResolvers) {
         argumentResolvers.add(new HeaderVersionArgumentResolver());
     }

    @GetMapping("/entity/{id}")
    public ResponseEntity findByVersion(
        @PathVariable Long id, @Version String version) {
        return ...;
    }

 **/