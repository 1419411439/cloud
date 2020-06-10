package springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xiezy.springcloud.entities.Payment;
import org.springframework.stereotype.Service;
import springcloud.service.PaymentService;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_OK() {
        return "线程池" + Thread.currentThread().getName() +
                "paymentInfo_OK";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    @Override
    public String paymentInfo_TimeOut() {

        int timeOutNum = 3;
        try {
            TimeUnit.SECONDS.sleep(timeOutNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池" + Thread.currentThread().getName() +
                "paymentInfo_TimeOut";
    }

    public String paymentInfo_TimeOutHandler() {
        return "fallback处理" + "线程池" + Thread.currentThread().getName() +
                "paymentInfo_TimeOutHandler";
    }
}
