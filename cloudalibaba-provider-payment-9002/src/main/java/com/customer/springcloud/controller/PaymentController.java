package com.customer.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * PaymentController
 *
 * @author Zichao Zhang
 * @date 2020/3/18
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/nacos/payment/{id}")
    public String nacosPayment(@PathVariable("id") Integer id) {
        return "register to nacos, port" + port + "; id: " + id;
    }

}
