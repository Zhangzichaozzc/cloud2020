package com.customer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ProviderPaymentConsul8006Application
 *
 * @author Zichao Zhang
 * @date 2020/3/15
 */
@SpringBootApplication
// 添加 EnalbeDiscoveryClient 之后，自己也可以获取到 自己的 注册到 Consul 中的服务
@EnableDiscoveryClient
public class ProviderPaymentConsul8006Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentConsul8006Application.class, args);
    }

}
