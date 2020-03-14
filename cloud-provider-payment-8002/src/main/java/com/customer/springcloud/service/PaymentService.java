package com.customer.springcloud.service;

import com.customer.springcloud.entity.Payment;

/**
 * PaymentService
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 */
public interface PaymentService {
    Payment create(Payment payment);

    Payment getPaymentById(Long id);
}
