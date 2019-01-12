package com.alonelaval.cornerstone.web.filter;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.cornerstone.entity.base.JsonResult;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.AbstractBasePermission;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author huawei
 * 验证URL的权限是否匹配
 * @create 2018-07-17
 **/
@Slf4j
public class UrlAuthenticationFilter extends AbstractJwtAuthorizationFilter {

    private List<RequestMatcher> requestMatchers = new ArrayList<>();

    public UrlAuthenticationFilter(FastJsonConfig fastJsonConfig) {
        super(fastJsonConfig);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        log.info(this.getClass().toString() +"::doFilterInternal");
        if(!requiresAuthentication(request)){
            filterChain.doFilter(request,response);
            return;
        }
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Authentication auth = UserContextHolder.getInstance().authentication();
        if(auth != null && ! (auth instanceof AnonymousAuthenticationToken)) {
            UserAdapter userAdapter = (UserAdapter) auth.getPrincipal();

            Set<String> userPerms = userAdapter.getUser().getUriPermissions().stream().map(AbstractBasePermission::getValue).collect(Collectors.toSet());

            log.info(userPerms.toString());

            String uri = getRequestPath(request);

            log.info(uri);
            //拥有权限
            if (userPerms.contains(uri)) {
                filterChain.doFilter(request,response);
                return;
            }
        }
        unsuccessfulAuthentication(request,response,JsonResult.builder().resultCode(ExceptionType.NOT_AUTH.value()).message("没有权限访问！").build());
    }



    private boolean requiresAuthentication(HttpServletRequest request){
        for (RequestMatcher requestMatcher : requestMatchers){
            if(requestMatcher.matches(request)){
                return true;
            }
        }
        return  false;
    }
    private String getRequestPath(HttpServletRequest request) {
        String url = request.getServletPath();
        if (request.getPathInfo() != null) {
            url += request.getPathInfo();
        }
        return url;
    }

    public UrlAuthenticationFilter antMatchers(String... antPatterns) {
        for (String pattern : antPatterns) {
            requestMatchers.add(new AntPathRequestMatcher(pattern));
        }
        return this;
    }

}
