package com.customer.springcloud.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * PaymentController
 *
 * @author Zichao Zhang
 * @date 2020/3/15
 */
@RestController
@Slf4j
public class PaymentController {

    public static final String URL_PREFIX = "http://cloud-consul-payment-service";

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consul")
    public String consul() {
        return port + ": " + UUID.randomUUID().toString();
    }

    @GetMapping("/rest/consul")
    public String restConsul() {
        return restTemplate.getForObject(URL_PREFIX + "/consul", String.class);
    }

}
