package com.alonelaval.cornerstone.web.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.alonelaval.cornerstone.web.common.*;
import com.alonelaval.cornerstone.web.exception.RestResponseStatusExceptionResolver;
import com.alonelaval.cornerstone.web.listener.YczServletContextListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.ResourceUtils;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;


/**
 * @author huawei
 * @create 2018-07-15
 **/
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {
    @Autowired
    ApplicationConfig config;

//    @Bean
//    public ServletListenerRegistrationBean<ServletContextListener> listenerRegistrationBean() {
//        ServletListenerRegistrationBean<ServletContextListener> bean =
//                new ServletListenerRegistrationBean<>();
//        bean.setListener(new YczServletContextListener());
//        return bean;
//
//    }

//    @Order(1)
    @Bean
    YczServletContextListener initializer(){
        return  new YczServletContextListener();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                        .allowedHeaders("*")
                        .allowedMethods("*")
                        .allowedOrigins("*");
    }


    @Bean(name = "fastJsonConfig")
    FastJsonConfig fastJsonConfig(){
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonConfig.setSerializeFilters(new YczValueFilter(config));
//        fastJsonConfig.setSerializeFilters(new EnumValueFilter());
        //valueFilter只能有一个
        return  fastJsonConfig;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //1、定义一个convert转换消息的对象
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.DisableCircularReferenceDetect.getMask();

        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //2、添加fastjson的配置信息

//        JSON.toJSONString()
        //3、在convert中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig());
        fastConverter.setSupportedMediaTypes(newArrayList(MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED));
        //4、将convert添加到converters中
        converters.add(fastConverter);
    }
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new IDSecurityConverter(config));
        registry.addConverter(new StringToEnumValueConverter());
        registry.addConverter(new StringToLocalDateConverter());
        registry.addConverter(new StringToLocalDateTimeConverter());
        registry.addConverter(new StringToLocalTimeConverter());
//        registry.addConverter(new LocalDateTimeConverter("yyyy-MM-dd'T'HH:mm:ss.SSS"));

//        resolvers.add(new RequestParamMethodArgumentResolver(getBeanFactory(), true));
//        resolvers.add(new ServletModelAttributeMethodProcessor(true));


    }

    @Override
    public void addArgumentResolvers(
        List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(new EnumArgumentResolver(config));
    }

    @Override
    protected void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
//        exceptionResolvers.a
     exceptionResolvers.add(2,new RestResponseStatusExceptionResolver());
//     exceptionResolvers.add(3,new YczResponseExceptionResolver());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/api/v2/api-docs", "/v2/api-docs");
        registry.addRedirectViewController("/api/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
        registry.addRedirectViewController("/api/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
        registry.addRedirectViewController("/api/swagger-resources", "/swagger-resources");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/swagger-ui.html**").addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
        registry.addResourceHandler("/api/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/")
//                .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS))

        ;
        registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");


    }

}
