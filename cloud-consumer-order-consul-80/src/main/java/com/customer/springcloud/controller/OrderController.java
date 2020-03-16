package com.customer.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * OrderController
 *
 * @author Zichao Zhang
 * @date 2020/3/15
 */
@RestController
@Slf4j
public class OrderController {

    private static final String URL_PREFIX = "http://cloud-consul-payment-com.customer.springcloud.service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/consul")
    public String consul() {
        return restTemplate.getForObject(URL_PREFIX + "/consul", String.class);
    }

}
