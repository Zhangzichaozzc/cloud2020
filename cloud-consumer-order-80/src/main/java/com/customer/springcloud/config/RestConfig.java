package com.customer.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestConfig
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 */
@Configuration
public class RestConfig {

    @Bean
    // @LoadBalanced 注解可以实现 Ribbon 提供的负载均衡，在 SpringCloud Hoxton.RS1 中
    // 如果想要基于 微服务名称访问，必须在注册 RestTemplate 组件时，添加 @LoadBalanced 注解
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
