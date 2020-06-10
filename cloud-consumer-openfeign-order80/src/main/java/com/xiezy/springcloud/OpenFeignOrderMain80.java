package com.xiezy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients     //启用openFeign功能
public class OpenFeignOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignOrderMain80.class, args);
    }
}
