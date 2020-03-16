package com.customer.springcloud.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
