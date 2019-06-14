package com.alonelaval.cornerstone.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@Configuration
@SpringBootTest
public class WebApplicationTests {

    @Test
    public void contextLoads() {
        String orgId = "1";
        Optional.of(orgId).ifPresent(Integer::parseInt);

    }

}
