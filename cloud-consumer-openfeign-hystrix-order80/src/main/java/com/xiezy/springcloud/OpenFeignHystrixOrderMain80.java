package com.xiezy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OpenFeignHystrixOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignHystrixOrderMain80.class, args);
    }
}
