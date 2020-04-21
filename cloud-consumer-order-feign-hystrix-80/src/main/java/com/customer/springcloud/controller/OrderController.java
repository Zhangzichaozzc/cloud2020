package com.customer.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.springcloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * Hystrix 的服务降级也可以用于 消费端，而且建议在消费端使用服务降级处理，在提供方调用时间过长或者出现异常的情况下
 * 在消费端直接做服务降级处理，保持消费端的性能
 * 开启服务端的服务降级处理，需要在 配置文件中添加 feign.hystrix.enabled=true 属性
 * 并且需要在主启动类上添加 @EanbleHystrix
 */
@RestController
/*
 * 1、@DefaultProperties 方法可以配置统一的 fallback 方法，在方法需要降级处理的时候，只需要在该方法的头上标注是上 @HystrixCommand 即可
 * 2、在需要特殊处理的需要使用 @HystrixCommand 的属性 fallbackMethod 来配置
 */
@DefaultProperties(defaultFallback = "defaultFallback")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/consumer/hystrix/ok")
    public String hystrixOk() {
        return orderService.hystrixOk();
    }

    @GetMapping("/consumer/hystrix/timeout")
    // HystrixCommand.xxxProperties 属性可以配置的 name值都可以在 com.netflix.hystrix.HystrixCommandProperties 类中找到
    @HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties = {
            // 客户端的服务降级处理， 默认是 timeout 超过 1秒就会 执行 fallback，所以
            // 要想使 在添加了 feign.hystrix.enable=true 后使自定义的超时时间需要在配置文件中再配置三项
            // hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=5000
            // ribbon.ReadTimeout=5000
            // ribbon.ConnectTimeout=5000
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String hystrixTimeout() {
        return orderService.hystrixTimeout();
    }

    @GetMapping("/hello")
    // 此处没有指明指定的 fallbackMethod， 使用 @DefaultProperties 中的 fallback 方法
    @HystrixCommand
    public String hello(Integer num) {
        if (num == 2) {
            throw new RuntimeException();
        }
        return "hello";
    }

    public String timeoutHandler() {
        return "在消费端做了服务降级处理";
    }

    // 全局的Fallback 方法不能有参数，并且全局Fallback 方法的返回值需要兼容 标注有 @HystrixCommand 的方法
    public String defaultFallback() {
        return "Default Fallback method, 默认降级处理方法";
    }
}
