package com.customer.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 第二种服务降级的处理: 当 提供端 宕机的时候启用 全局的 fallback
 * 结局方案： 在 @FeignClient 的 fallback 属性指定统一的fallback 处理
 * 但是，fallback 指定的类必须要在 容器中注册
 * 在 @FeignClient 中指定的 fallback 会被使用 @HystrixCommand 注解指定的fallback 覆盖
 */
@Service
@FeignClient(name = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = OrderServiceFallback.class)
public interface OrderService {
    @GetMapping("/hystrix/ok")
    String hystrixOk();

    @GetMapping("/hystrix/timeout")
    String hystrixTimeout();


}
