package com.xiezy.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK() {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,哈哈";
    }

    @Override
    public String paymentInfo_TimeOut() {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }
}
