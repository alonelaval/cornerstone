package com.alonelaval.cornerstone.web.filter;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.cornerstone.web.config.ApplicationConfig;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.header.HeaderWriter;
import org.springframework.security.web.header.HeaderWriterFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author huawei
 * PC端登录后，在首页添加header
 * @create 2018-07-15
 **/
@Slf4j
@Data
public class JwtGenerateFilter extends HeaderWriterFilter {
    private ApplicationConfig config;
    private  JwtTokenGenerator jwtTokenGenerator;


    public JwtGenerateFilter(ApplicationConfig config, JwtTokenGenerator jwtTokenGenerator) {
        super(newArrayList(new HeaderWriter() {
            @Override
            public void writeHeaders(HttpServletRequest request, HttpServletResponse response) {
                log.info(JwtGenerateFilter.class.getName()+":"+request.getRequestURI());
//                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                Authentication auth = UserContextHolder.getInstance().authentication();
                if(auth != null && ! (auth instanceof AnonymousAuthenticationToken)) {
                    response.addHeader(config.getHeader(), config.getPrefix() + " " + jwtTokenGenerator.generate(auth,config));
                }
            }
        }));
        this.config = config;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        log.info(JwtGenerateFilter.class.getName()+":"+request.getRequestURI());
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if(auth != null && ! (auth instanceof AnonymousAuthenticationToken)) {
//            response.addHeader(config.getHeader(), config.getPrefix() + " " + jwtTokenGenerator.generate(auth,config));
//        }
//        filterChain.doFilter(request,response);
//    }

//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        chain.doFilter(request,response);
//
//        log.info(JwtGenerateFilter.class.getName()+":"+httpRequest.getRequestURI());
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if(auth != null && ! (auth instanceof AnonymousAuthenticationToken)) {
//            httpResponse.addHeader(config.getHeader(), config.getPrefix() + " " + jwtTokenGenerator.generate(auth,config));
//        }
//
//    }
}
