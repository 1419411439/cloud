package com.xiezy.springcloud.controller;

import com.xiezy.springcloud.common.CommonResult;
import com.xiezy.springcloud.entities.Payment;
import com.xiezy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return new CommonResult(200, "查询成功, serverPort:" + serverPort, payment);
    }

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment) {
        int changeNum = paymentService.create(payment);

        if (changeNum > 0) {
            return new CommonResult(200, "新增支付流水成功", changeNum);
        } else {
            return new CommonResult(200, "新增支付流水失败");
        }
    }
}
