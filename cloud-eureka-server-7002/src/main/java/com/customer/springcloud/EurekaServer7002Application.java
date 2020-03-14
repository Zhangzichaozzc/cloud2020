package com.customer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * com.customer.springcloud.EurekaServer7002Application
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7002Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7002Application.class, args);
    }

}
