package com.customer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ProviderPaymentZookeeper8004Application
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 * <p>
 * <p>
 * 将服务注册进 zookeeper， 则会在 zookeeper 中生成一个临时的 ZNODE(节点) 来保存数据，
 * 在指定的心跳周期内如果没有继续收到 微服务的心跳，则 zookeeper 会将这个节点删除
 */
@SpringBootApplication
// 需要使用到 @EnableDiscoveryClient 来 使用 zookeeper 客户端 注册服务信息
@EnableDiscoveryClient
public class ProviderPaymentZookeeper8004Application {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentZookeeper8004Application.class, args);
    }
}
