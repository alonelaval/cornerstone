package com.alonelaval.cornerstone.web.filter;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.http.HttpRequestUtil;
import com.alonelaval.cornerstone.cache.UserCache;
import com.alonelaval.cornerstone.entity.base.JsonResult;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.web.config.ApplicationConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * @author huawei 验证是否使用jwt来标记登录
 * @create 2018-07-15
 **/
@Slf4j
public class JwtAuthorizationFilter extends AbstractJwtAuthorizationFilter {
    private ApplicationConfig config;
    private Set<String> exclude;
    public JwtAuthorizationFilter(ApplicationConfig config, FastJsonConfig fastJsonConfig,Set<String> exclude) {
        super(fastJsonConfig);
        this.config = config;
        this.exclude =exclude;

    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        // TODO: 2018/7/18 应该从缓存里面取
        try {
            String uri = HttpRequestUtil.getRequestUri(req);
            if(exclude.contains(uri) || uri.contains(".css") || uri.contains(".js") || uri.contains(".png")||
                    uri.contains(".jpg")|| uri.contains("/static")){
                chain.doFilter(req, res);
                return;
            }
            Authentication authentication = getAuthentication(req, res);
            if(authentication != null){
                UserAdapter userAdapter = (UserAdapter) authentication.getPrincipal();
                log.info("doFilterInternal,header:{}",userAdapter.getUser().getUserId());
                //刷新缓存
                UserCache.getInstance().put(userAdapter.getUser().getLoginName(),authentication);
                UserContextHolder.getInstance().setAuthentication(authentication);

                chain.doFilter(req, res);
            }
            else {
                unsuccessfulAuthentication(req,res,JsonResult.builder().resultCode(ExceptionType.RESULT_USER_NEED_LOGIN.value())
                        .message("需要登录！").build());
            }
        }catch (Exception ex){
            unsuccessfulAuthentication(req,res,JsonResult.builder().resultCode(ExceptionType.RESULT_USER_NEED_LOGIN.value())
                    .message("身份验证失败，请重新登录系统！").build());
        }

    }


    private Authentication getAuthentication(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException {
        if(UserContextHolder.getInstance().authentication() != null &&
                !UserContextHolder.getInstance().isAnonymous()
                ) {
            return UserContextHolder.getInstance().authentication();
        }
        String token = request.getHeader(config.getHeader());
        if (!StringUtils.isBlank(token)) {
            try {
                token = token.replace(config.getPrefix() + " ", "");
                System.out.println(config.getJwtSecret());
                System.out.println(token);
                Claims claims = Jwts.parser()
                        .setSigningKey(config.getJwtSecret().getBytes())
                        .parseClaimsJws(token)
                        .getBody();
                String username = claims.getSubject();
                if (username != null) {
                    return  UserCache.getInstance().get(username);
                }
            }catch (JwtException ex){
                throw  ex;
            }
        }
        return null;
    }



    public ApplicationConfig getConfig() {
        return config;
    }

    public void setConfig(ApplicationConfig config) {
        this.config = config;
    }


}
