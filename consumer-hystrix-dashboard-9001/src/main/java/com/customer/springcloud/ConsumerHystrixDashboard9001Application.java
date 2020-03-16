package com.customer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * ConsumerHystrixDashboard9001Application
 *
 * @author Zichao Zhang
 * @date 2020/3/16
 */
@SpringBootApplication
// 添加 HystrixDashboard 功能
@EnableHystrixDashboard
public class ConsumerHystrixDashboard9001Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashboard9001Application.class, args);
    }

}
