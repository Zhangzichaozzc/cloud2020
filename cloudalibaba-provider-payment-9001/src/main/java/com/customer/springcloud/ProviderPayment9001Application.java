package com.customer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ProviderPayment9001Application
 *
 * @author Zichao Zhang
 * @date 2020/3/18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPayment9001Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment9001Application.class, args);
    }

}
