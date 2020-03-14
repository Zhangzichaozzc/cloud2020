package com.customer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ConsumerOrderZookeeper80Application
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerOrderZookeeper80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderZookeeper80Application.class, args);
    }

}
