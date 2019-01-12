package com.alonelaval.common;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author huawei
 * @create 2018-10-22
 **/
@SpringBootApplication
public class CommonApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
//                .bannerMode(Banner.Mode.CONSOLE)
                .sources( CommonApplication.class)
                .run(args);
    }
}
