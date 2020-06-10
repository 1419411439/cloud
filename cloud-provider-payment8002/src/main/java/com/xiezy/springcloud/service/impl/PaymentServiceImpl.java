package com.xiezy.springcloud.service.impl;

import com.xiezy.springcloud.entities.Payment;
import org.springframework.stereotype.Service;
import com.xiezy.springcloud.dao.PaymentDao;
import com.xiezy.springcloud.service.PaymentService;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
