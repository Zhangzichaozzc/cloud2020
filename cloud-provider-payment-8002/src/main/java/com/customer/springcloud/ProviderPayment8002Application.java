package com.customer.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ProviderPayment8002Application
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 */
@SpringBootApplication
@MapperScan("com.customer.springcloud.mapper")
@EnableEurekaClient
public class ProviderPayment8002Application {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment8002Application.class, args);
    }
}
