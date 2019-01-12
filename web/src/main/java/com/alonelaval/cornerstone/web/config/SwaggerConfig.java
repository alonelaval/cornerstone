package com.alonelaval.cornerstone.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author huawei
 * @create 2018-07-14
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfo(
                "优成长api文档",
                "Some custom description of API.",
                "API TOS",
                "Terms of service",
                new Contact("华卫", "alonelaval.com", "120huawei@163.com"),
                "License of API", "API license URL", Collections.emptyList());
    }



//    public SecurityConfiguration security() {
//        return SecurityConfigurationBuilder.builder()
//                .clientId("huawei")
//                .clientSecret("huawei")
//                .scopeSeparator(" ")
//                .useBasicAuthenticationWithAccessCodeGrant(true)
//                .build();
//    }

}

