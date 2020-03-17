package com.customer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * com.customer.springcloud.ConfigClient3366Application
 *
 * @author Zichao Zhang
 * @date 2020/3/17
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient3366Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3366Application.class, args);
    }

}
