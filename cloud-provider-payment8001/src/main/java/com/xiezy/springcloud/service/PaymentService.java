package com.xiezy.springcloud.service;

import com.xiezy.springcloud.entities.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
