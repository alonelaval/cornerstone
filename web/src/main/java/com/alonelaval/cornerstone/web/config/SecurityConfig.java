package com.alonelaval.cornerstone.web.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alonelaval.cornerstone.service.user.CustomUserDetailsService;
import com.alonelaval.cornerstone.web.filter.*;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.Arrays;



/**
 * @author huawei
 * @create 2018-07-13
 **/

@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    ApplicationConfig jwtAuthenticationConfig;
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private FastJsonConfig fastJsonConfig;


    @Configuration
    @Order(1)
    public  class PcAppConfigurationAdapter extends WebSecurityConfigurerAdapter {
        public PcAppConfigurationAdapter() {
            super();
        }
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/index").permitAll()
                    .antMatchers("/user/login").permitAll()
                    .antMatchers("/user/apiLogin").permitAll()
                    .antMatchers("/user/orgRegister").permitAll()
                    .antMatchers("/user/orgUserRegister").permitAll()
                    .antMatchers("/user/userRegister").permitAll()
                    .antMatchers("/user/findPassword").permitAll()
                    .antMatchers("/kaptcha").permitAll()
                    .antMatchers("/api/*").permitAll()
                    .antMatchers("/smsMessage/*").permitAll()
                    .antMatchers("/*").permitAll() //测试放开所有
//                    .antMatchers("/user/**").authenticated()
//                    .antMatchers("/api/**").authenticated()
                    .and()
                    .formLogin().loginPage("/user/login")
                    .and()
                    .logout()
                    .logoutUrl("/logout");
            http.addFilterBefore(kaptchaCheckFilter(),CustomUsernamePasswordAuthenticationFilter.class);
            http.addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        }
        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/*.css");
            web.ignoring().antMatchers("/*.js");
            web.ignoring().antMatchers("/css/**");
            web.ignoring().antMatchers("/*.html");
        }


        public CustomUsernamePasswordAuthenticationFilter authenticationFilter() throws Exception {
            CustomUsernamePasswordAuthenticationFilter filter = new CustomUsernamePasswordAuthenticationFilter(jwtAuthenticationConfig);
            filter.setAuthenticationManager(authenticationManagerBean());
            filter.setAuthenticationFailureHandler(failureHandler());
            return filter;
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(authProvider());
        }



    }



    @Bean(name = "kaptchaCheckFilter")
    public Filter kaptchaCheckFilter() {

        return new KaptchaCheckFilter();
    }


    @Bean
    public FilterRegistrationBean corsFilter() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("X-Requested-With","Origin","Content-Type","Accept","Authorization"));

        // This allow us to expose the headers
        configuration.setExposedHeaders(Arrays.asList("Access-Control-Allow-Headers", "Authorization, x-xsrf-token, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, " +
                "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }



    @Bean
    public FilterRegistrationBean apiFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(apiLoginFilter());
        registration.addUrlPatterns("/user/apiLogin");
        registration.setName("apiLoginFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean(name = "apiLoginFilter")
    public Filter apiLoginFilter()  {
        ApiCustomAuthenticationFilter filter = new ApiCustomAuthenticationFilter(jwtAuthenticationConfig,jwtTokenGenerator(),fastJsonConfig);
        filter.setJwtTokenGenerator(jwtTokenGenerator());
        filter.setPasswordEncoder(passwordEncoder());
        filter.setUserDetailsService(userDetailsService);
        return filter;
    }


    @Bean
    public FilterRegistrationBean indexJwtFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(jwtGenerateFilter());
        registration.addUrlPatterns("/user/index","/user/orgRegister","/user/userRegister");
        registration.setName("jwtFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean(name = "jwtFilter")
    public Filter jwtGenerateFilter() {
        return
                new JwtGenerateFilter(jwtAuthenticationConfig,jwtTokenGenerator());
    }


    @Bean
    public FilterRegistrationBean jwtAuthorizationFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(jwtAuthorizationFilter());
        registration.addUrlPatterns("/*");
        registration.setName("jwtAuthorizationFilter");
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setOrder(1);

        return registration;
    }

    @Bean(name = "jwtAuthorizationFilter")
    public Filter jwtAuthorizationFilter() {
        return new JwtAuthorizationFilter(jwtAuthenticationConfig,fastJsonConfig,Sets.newHashSet(
                "/user/apiLogin","/kaptcha","/","/platform"
        ));
    }

    @Bean
    public FilterRegistrationBean urlAuthenticationFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(urlAuthenticationFilter());
        registration.addUrlPatterns("/test/*");
        registration.setName("urlAuthenticationFilter");
        registration.setOrder(3);
        return registration;
    }

    @Bean(name = "urlAuthenticationFilter")
    public Filter urlAuthenticationFilter() {
        return new UrlAuthenticationFilter(fastJsonConfig).antMatchers("/test/*","/class/*");
    }


    @Bean
    public JwtTokenGenerator jwtTokenGenerator(){
        return  new JwtTokenGenerator();
    }

    @Bean
    public AuthenticationProvider authProvider() {
        return new CustomUserDetailsAuthenticationProvider(passwordEncoder(), userDetailsService);
    }
    @Bean
    public SimpleUrlAuthenticationFailureHandler failureHandler() {
        return new SimpleUrlAuthenticationFailureHandler("/user/login?error=true");
    }
    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



//    @Configuration
//    public class CORSConfiguration {

//    }

}