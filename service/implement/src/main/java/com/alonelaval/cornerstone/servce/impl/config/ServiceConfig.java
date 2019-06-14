package com.alonelaval.cornerstone.servce.impl.config;

import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author huawei
 * @create 2018-07-13
 **/
@Getter
@ToString
@PropertySource("classpath:service.properties")
@Configuration
public class ServiceConfig implements InitializingBean {
    @Value("${org.user.defaultRoleIds}")
    private String orgDefaultRoleIds;

    @Value("${client.user.defaultRoleIds}")
    private String clientDefaultRoleIds;

    private List<Integer> orgDefaultRoleIdList;
    private List<Integer> clientDefaultRoleIdList;



    @Override
    public void afterPropertiesSet() throws Exception {
        if(StringUtils.isNotBlank(orgDefaultRoleIds)){
            orgDefaultRoleIdList = Stream.of(orgDefaultRoleIds.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        }
        if(StringUtils.isNotBlank(clientDefaultRoleIds)){
            clientDefaultRoleIdList = Stream.of(clientDefaultRoleIds.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        }
    }
}
