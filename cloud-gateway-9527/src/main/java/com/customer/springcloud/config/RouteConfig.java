package com.customer.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RouteConfig
 *
 * @author Zichao Zhang
 * @date 2020/3/17
 */
@Configuration
public class RouteConfig {

    /**
     * 通过编码的方式在容器中注入 自定义的 RouteLocator 来 设置路由规则进行路由
     */
//    @Bean
//    public RouteLocator customizeRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("path_route", p -> p.path("/payment/**").uri("lb://CLOUD-PAYMENT-SERVICE"))
//                .route("path_route2", p -> p.path("/ping/**").uri("lb://CLOUD-PAYMENT-SERVICE"))
//                .build();
//
//    }

}
