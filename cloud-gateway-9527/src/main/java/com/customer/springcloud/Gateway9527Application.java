package com.customer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Gateway9527Application
 *
 * @author Zichao Zhang
 * @date 2020/3/17
 */
@SpringBootApplication
@EnableEurekaClient
public class Gateway9527Application {

    public static void main(String[] args) {
        SpringApplication.run(Gateway9527Application.class, args);
    }

}
