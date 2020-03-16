package com.customer.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.customer.springcloud.service.PayService;

/**
 * PaymentController
 *
 * @author Zichao Zhang
 * @date 2020/3/16
 */
@RestController
public class PaymentController {

    @Autowired
    private PayService payService;

    @GetMapping("/hystrix/ok")
    public String hystrixOk() {
        return payService.hystrixOk();
    }

    @GetMapping("/hystrix/timeout")
    public String hystrixTimeout() {
        return payService.hystrixTimeout();
    }

    @GetMapping("/circuit/{id}")
    public String circuit(@PathVariable("id") Integer id) {
        return payService.circuitBreaker(id);
    }

}
