package com.customer.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * OrderController
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 */
@RestController
public class OrderController {

    private static final String URL_PREFIX = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/zk")
    public String zk() {
        return restTemplate.getForObject(URL_PREFIX + "/zk", String.class);
    }

}
