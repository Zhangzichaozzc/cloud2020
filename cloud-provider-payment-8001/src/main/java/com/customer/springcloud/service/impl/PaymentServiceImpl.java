package com.customer.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.springcloud.entity.Payment;
import com.customer.springcloud.mapper.PaymentMapper;
import com.customer.springcloud.service.PaymentService;

/**
 * PaymentServiceImpl
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Payment create(Payment payment) {
        paymentMapper.save(payment);
        return payment;
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getById(id);
    }
}
