package com.customer.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ProviderPayment8001Application
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 */
@SpringBootApplication
@MapperScan("com.customer.springcloud.mapper")
@EnableEurekaClient
// 开启 服务发现客户端
@EnableDiscoveryClient
public class ProviderPayment8001Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment8001Application.class, args);
    }

}
