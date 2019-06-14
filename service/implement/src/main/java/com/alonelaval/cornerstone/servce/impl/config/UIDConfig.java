package com.alonelaval.cornerstone.servce.impl.config;

import com.alonelaval.common.snowflake.SnowflakeUidGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huawei
 * @create 2018-08-05
 **/
@Configuration
public class UIDConfig {
    @Bean
    public SnowflakeUidGenerator userOrderUidGenerator() {
        long workerId = SnowflakeUidGenerator.getWorkerIdByIP(24);
        return new SnowflakeUidGenerator(workerId);
    }

    // init multiple uid generators for different DB tables
    @Bean
    public SnowflakeUidGenerator platformOrderUidGenerator() {
        long workerId = SnowflakeUidGenerator.getWorkerIdByIP(24);
        return new SnowflakeUidGenerator(workerId);
    }
}
