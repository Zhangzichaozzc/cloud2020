package com.customer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ConsumerOreder80Application
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableEurekaClient
public class ConsumerOreder80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOreder80Application.class, args);
    }

}
