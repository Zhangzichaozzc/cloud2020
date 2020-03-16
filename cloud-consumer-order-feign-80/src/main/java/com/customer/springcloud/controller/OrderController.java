package com.customer.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.springcloud.entity.CommonResult;
import com.customer.springcloud.service.OrderService;

/**
 * OrderController
 *
 * @author Zichao Zhang
 * @date 2020/3/15
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/consumer/ping")
    public CommonResult<Integer> ping() {
        return orderService.ping();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/consumer/timeout")
    public String timeout() {
        return orderService.timeout();
    }

}
