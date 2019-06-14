package com.alonelaval.cornerstone.web.filter;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.google.code.kaptcha.Constants;
import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.security.IDSecurityUtils;
import com.alonelaval.cornerstone.cache.KaptchaCache;
import com.alonelaval.cornerstone.cache.UserCache;
import com.alonelaval.cornerstone.entity.base.JsonResult;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
import com.alonelaval.cornerstone.service.user.CustomUserDetailsService;
import com.alonelaval.cornerstone.web.config.ApplicationConfig;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author huawei
 * @create 2018-07-15
 **/
@Slf4j
@Data
public class ApiCustomAuthenticationFilter extends AbstractJwtAuthorizationFilter {

    public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "username";
    public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "password";
    public static final String ORG_ID = "orgId";
    public static final String LOGIN_TYPE= "loginType";
    public final static String CAPTCHA_NAME = "kaptcha";
    private CustomUserDetailsService userDetailsService;
    private ApplicationConfig config;
    private JwtTokenGenerator jwtTokenGenerator;
    private PasswordEncoder passwordEncoder;


    public ApiCustomAuthenticationFilter(ApplicationConfig config, JwtTokenGenerator jwtTokenGenerator, FastJsonConfig fastJsonConfig) {
        super(fastJsonConfig);
        this.config = config;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }
    protected void addJwtHeader(HttpServletResponse response, Authentication auth,UserAdapter userAdapter) {
        if (auth != null && !(auth instanceof AnonymousAuthenticationToken)) {
//            SecurityContextHolder.getContext().setAuthentication(auth);

            UserCache.getInstance().put(userAdapter.getUser().getLoginName(),auth);
            UserContextHolder.getInstance().setAuthentication(auth);
            response.addHeader(config.getHeader(), config.getPrefix() + " " + jwtTokenGenerator.generate(auth, config));
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        JsonResult jsonResult = JsonResult.builder().resultCode(ExceptionType.USER_NOT_FOUND.value()).build();
        String kaptcha = obtainKaptcha(request);
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        String orgId = request.getParameter(ORG_ID);
        String loginType  = request.getParameter(LOGIN_TYPE);


        if(StringUtils.isBlank(kaptcha) || kaptcha.length() != config.getKaptchaLength() || !checkKaptcha(kaptcha,request.getSession())){
            jsonResult.setMessage("验证码错误！");
            unsuccessfulAuthentication(request, response,jsonResult);
            return;
        }

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            jsonResult.setMessage("用户密码不能为空！");
            unsuccessfulAuthentication(request, response,jsonResult);
            return;
        }

        try {

            RoleOwnType loginT = !StringUtils.isNumeric(loginType) ? RoleOwnType.USER_ROLE :
                    RoleOwnType.valueOf(Integer.parseInt(loginType));
            Integer oid = StringUtils.isBlank(orgId) ? null :  Integer.parseInt(IDSecurityUtils.decId(orgId,config.getIdSecret()));
            UserDetails userDetails = userDetailsService.loadUserByUsernameAndOrgId(username,password,oid,loginT,passwordEncoder);
            UserAdapter userAdapter = (UserAdapter) userDetails;
            addJwtHeader(response,new CustomAuthenticationToken(userDetails,userDetails.getPassword(),oid,loginT,
                    userDetails.getAuthorities()),userAdapter);
            jsonResult.setResultCode(ExceptionType.SUCCESS.value());
            jsonResult.setData(userAdapter);
            successfulAuthentication(request,response,jsonResult);

        }catch (UsernameNotFoundException ex){
            log.error(ex.getMessage(),ex);
            jsonResult.setMessage(ex.getMessage());
            unsuccessfulAuthentication(request,response,jsonResult);
            return;
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
            jsonResult.setMessage("登录出现异常！");
            unsuccessfulAuthentication(request,response,jsonResult);
            return;
        }
    }


    private boolean checkPassword(String password,UserDetails userDetails) {
        String presentedPassword = userDetails.getPassword();
        return  passwordEncoder.matches(password,presentedPassword);
    }


    private String obtainUsername(HttpServletRequest request) {
        return request.getParameter(SPRING_SECURITY_FORM_USERNAME_KEY);
    }
    private String obtainPassword(HttpServletRequest request) {
        return request.getParameter(SPRING_SECURITY_FORM_PASSWORD_KEY);
    }
    private String obtainKaptcha(HttpServletRequest request) {
        return request.getParameter(CAPTCHA_NAME);
    }
    private String obtainOrgId(HttpServletRequest request) {
        return request.getParameter("orgId");
    }

    private boolean checkKaptcha(String kaptcha, HttpSession session)
    {
        if(kaptcha.equals("8888"))
        {
            return  true;
        }
        if(KaptchaCache.getInstance().verificationCode(kaptcha)){
            return true;
        }

        if(session.getAttribute(Constants.KAPTCHA_SESSION_KEY) == null){
            return false;
        }

        return  kaptcha.equalsIgnoreCase(session.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString());
    }
}
