package com.customer.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ConsumerController
 *
 * @author Zichao Zhang
 * @date 2020/3/18
 */
@RestController
public class ConsumerController {

    @Value("${service-url.nacos-provider-payment}")
    public String url;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/nacos/payment/{id}")
    public String nacosConsumer(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(url + "/nacos/payment/" + id, String.class);
    }

}
