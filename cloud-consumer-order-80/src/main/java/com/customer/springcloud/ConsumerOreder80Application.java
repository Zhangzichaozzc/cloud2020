package com.customer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.customer.rule.MyRule;

/**
 * ConsumerOreder80Application
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 */
@SpringBootApplication
// 在 Eureka Client 中不需要添加 @EurekaDiscoveryClient 就可以实现 服务发现
//@EnableDiscoveryClient
@EnableEurekaClient
// 使用 @RibbonClient 注解，必须指定 name， configuration 指定 对指定的服务使用的 负载均衡策略
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyRule.class)
public class ConsumerOreder80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOreder80Application.class, args);
    }

}
