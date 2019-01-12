package com.alonelaval.cornerstone.web.filter;

import com.alonelaval.common.security.IDSecurityUtils;
import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
import com.alonelaval.cornerstone.web.config.ApplicationConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * @author huawei
 * @create 2018-07-13
 **/
@Slf4j
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static final String SPRING_SECURITY_FORM_ORGID_KEY = "orgId";

    public static final String LOGIN_TYPE= "loginType";
    private JwtTokenGenerator jwtTokenGenerator = new JwtTokenGenerator();
    private ApplicationConfig config;
    public CustomUsernamePasswordAuthenticationFilter(ApplicationConfig config) {
        this.config = config;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        if (!"POST".equals(request.getMethod())) {
            throw new AuthenticationServiceException("Authentication method not supported: "
                    + request.getMethod());
        }

        CustomAuthenticationToken authRequest = getAuthRequest(request);
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {

        this.addJwtHeader(response,authResult);
        super.successfulAuthentication(request,response,chain,authResult);
    }

    protected void addJwtHeader(HttpServletResponse response,Authentication auth){
        if(auth != null && ! (auth instanceof AnonymousAuthenticationToken)) {
            response.addHeader(config.getHeader(), config.getPrefix() + " " + jwtTokenGenerator.generate(auth,config));
        }
    }

    private CustomAuthenticationToken getAuthRequest(HttpServletRequest request)throws  AuthenticationException {
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        String orgIdParam= obtainDomain(request);
        String loginTypeParam= request.getParameter(LOGIN_TYPE);
        Integer orgId = null;
        RoleOwnType loginType=RoleOwnType.USER_ROLE;
        log.info("orgId is : {}" ,orgIdParam);

        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }
        if(StringUtils.isNumeric(loginTypeParam)){
            loginType = RoleOwnType.valueOf(Integer.parseInt(loginTypeParam));
        }
        if (orgIdParam == null) {
            orgIdParam = null;
        }
        else{
            try {
                orgId  =  StringUtils.isBlank(orgIdParam) ? null :  Integer.parseInt(IDSecurityUtils.decId(orgIdParam,config.getIdSecret()));

            }catch (Exception e){
                    throw new UsernameNotFoundException("机构编号不对！",e);
            }
        }

        return new CustomAuthenticationToken(username, password,orgId,loginType);
    }

    private String obtainDomain(HttpServletRequest request) {
        return request.getParameter(SPRING_SECURITY_FORM_ORGID_KEY);
    }
}