package com.customer.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 注意在使用自定义的 轮询算法来获取服务地址的时候，需要将 @LoadBalanced 注销掉，
 * 否则 是一个 ServiceInstance.getUri 获取的服务地址无法访问复苏
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
