package com.xiezy.springcloud.controller;

import com.xiezy.springcloud.common.CommonResult;
import com.xiezy.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/consumer")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    //private static final String PAYMENT_URL = "http://localhost:8001";
    //以服务在Eureka中注册的名称作为访问url，需要为RestTemplate配置负载均衡
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    /**
     * 提供给客户使用，通过restTemplate调用cloud-provider-payment模块
     * 所以使用GET请求
     * @param payment
     * @return
     */
    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
