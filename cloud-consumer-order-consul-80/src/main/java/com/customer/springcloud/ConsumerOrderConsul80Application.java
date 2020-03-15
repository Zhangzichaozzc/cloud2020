package com.customer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ConsumerOrderConsul80Application
 *
 * @author Zichao Zhang
 * @date 2020/3/15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerOrderConsul80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderConsul80Application.class, args);
    }

}
