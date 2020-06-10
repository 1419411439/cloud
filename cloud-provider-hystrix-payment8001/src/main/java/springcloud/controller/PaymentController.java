package springcloud.controller;

import com.xiezy.springcloud.common.CommonResult;
import com.xiezy.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springcloud.service.PaymentService;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/ok")
    public String paymentInfo_OK()
    {
        String result = paymentService.paymentInfo_OK();
        log.info("*****result: "+result);
        return result;
    }

    @GetMapping("/hystrix/timeout")
    public String paymentInfo_TimeOut()
    {
        String result = paymentService.paymentInfo_TimeOut();
        log.info("*****result: "+result);
        return result;
    }
}
