package com.customer.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * OrderServiceFallback
 *
 * @author Zichao Zhang
 * @date 2020/3/16
 */
@Component
public class OrderServiceFallback implements OrderService {
    @Override
    public String hystrixOk() {
        return "Down Fallback";
    }

    @Override
    public String hystrixTimeout() {
        return "Down Fallback";
    }
}
