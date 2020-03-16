package com.customer.springcloud.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.springcloud.entity.CommonResult;
import com.customer.springcloud.entity.Payment;
import com.customer.springcloud.service.PaymentService;

/**
 * PaymentController
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 */
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * discoveryClient 可以获取到 Eureka Server 中的 com.customer.springcloud.service 服务 信息
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private Integer port;

    @PostMapping("/payment")
    public CommonResult<Payment> save(@RequestBody Payment payment) {
        paymentService.create(payment);
        CommonResult<Payment> result = new CommonResult<>();
        result.setData(payment);
        return result;
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment == null) {
            throw new NullPointerException();
        }
        CommonResult<Payment> result = new CommonResult<>();
        result.setData(payment);
        return result;
    }

    @GetMapping("/ping")
    public CommonResult<Integer> ping() {
        CommonResult<Integer> result = new CommonResult<>();
        result.setData(port);
        return result;
    }

    @GetMapping("/discovery")
    public Object discovery() {
        for (String service : discoveryClient.getServices()) {
            System.err.println(service);
        }

        for (ServiceInstance instance : discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE")) {
            System.out.println(instance.getServiceId() + ", " + instance.getHost() + ": " + instance.getPort() + ": " + instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("/timeout")
    public String timeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port + "";
    }



}
