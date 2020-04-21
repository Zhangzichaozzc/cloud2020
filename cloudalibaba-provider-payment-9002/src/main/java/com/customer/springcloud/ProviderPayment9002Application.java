package com.customer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * com.customer.springcloud.ProviderPayment9002Application
 *
 * @author Zichao Zhang
 * @date 2020/3/18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPayment9002Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment9002Application.class, args);
    }

}
