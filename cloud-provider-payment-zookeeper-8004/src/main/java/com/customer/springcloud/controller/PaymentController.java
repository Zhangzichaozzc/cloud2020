package com.customer.springcloud.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PaymentController
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/zk")
    public String zk() {
        return port + UUID.randomUUID().toString();
    }

}
