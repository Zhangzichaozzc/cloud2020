package com.customer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * NacosConfigClient3377Application
 *
 * @author Zichao Zhang
 * @date 2020/3/18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClient3377Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClient3377Application.class, args);
    }

}
