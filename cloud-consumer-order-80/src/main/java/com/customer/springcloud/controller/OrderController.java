package com.customer.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.customer.springcloud.entity.CommonResult;
import com.customer.springcloud.entity.Payment;

/**
 * OrderController
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 */
@RestController
public class OrderController {

    //    private static final String URL_PREFIX = "http://localhost:8001";
    // 在 主配置类中 启动了 @EnableEurekaClient 后可以通过注册名去访问 服务提供者
    // 在 Spring Cloud Hoxton.RS1 中， 直接 添加 @EnableEurekaClient 不行，会报错，解决 bug 需要在 RestTemplate 组件注册时添加 @LoadBalanced 注解
    private static final String URL_PREFIX = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment")
    public CommonResult<Payment> save(@RequestBody Payment payment) {
        CommonResult result = restTemplate.postForObject(URL_PREFIX + "/payment", payment, CommonResult.class);
        return result;
    }

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URL_PREFIX + "/payment/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/ping")
    public CommonResult<String> getById() {
        return restTemplate.getForObject(URL_PREFIX + "/ping", CommonResult.class);
    }

    /**
     * 测试 RestTemplate.getForEntity() 方法的使用
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/entity/payment/{id}")
    public ResponseEntity<CommonResult> getEntityById(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(URL_PREFIX + "/payment/" + id,
                CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            System.err.println("entity.getHeaders() = " + entity.getHeaders());
            return entity;
        }
        return null;
    }
}
