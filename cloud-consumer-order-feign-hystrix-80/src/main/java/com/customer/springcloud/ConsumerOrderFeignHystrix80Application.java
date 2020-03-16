package com.customer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ConsumerOrderFeignHystrix80Application
 *
 * @author Zichao Zhang
 * @date 2020/3/16
 */
@SpringBootApplication
@EnableFeignClients
// 在 客户端开启服务降级 需要添加 @EnableHystrix 注解
@EnableHystrix
public class ConsumerOrderFeignHystrix80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderFeignHystrix80Application.class, args);
    }

}
