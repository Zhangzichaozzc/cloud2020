package com.customer.rule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 使用 @RibbonClient 在指定的 服务上添加 负载均衡策略，则该 组件的注入，不能在 @ComponentScan扫描的包下
 */
@Configuration
public class MyRule {

    @Bean
    public IRule cusRule() {
        return new RandomRule();
    }

}
