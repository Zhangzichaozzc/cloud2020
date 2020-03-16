package com.customer.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.customer.springcloud.entity.CommonResult;

/**
 * OrderService
 *
 * @author Zichao Zhang
 * @date 2020/3/15
 */
// @FeignClient 注解需要填写要处理的是哪个 服务
@FeignClient("CLOUD-PAYMENT-SERVICE")
@Component
public interface OrderService {
    @GetMapping("/ping")
    CommonResult<Integer> ping();

    @GetMapping("/timeout")
    String timeout();
}
