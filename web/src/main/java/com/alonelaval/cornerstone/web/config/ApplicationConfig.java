package com.alonelaval.cornerstone.web.config;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author huawei
 * @create 2018-07-13
 **/
@Getter
@ToString
@Configuration
public class ApplicationConfig {
    @Value("${security.jwt.url:/login}")
    private String url;

    @Value("${security.jwt.header:Authorization}")
    private String header;

    @Value("${security.jwt.prefix:Bearer}")
    private String prefix;
    // default 24 hours
    @Value("${security.jwt.expiration:#{24*60*60}}")
    private int expiration;

    @Value("${security.jwt.secret:121212121}")
    private String jwtSecret;

    @Value("${security.id.secret:12345678}")
    private String idSecret;
    @Value("${security.kaptcha.length:4}")
    private Integer kaptchaLength;
    @Value("${server.file.path}")
    private String filePath;
}
