package com.xiezy.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ribbon官方建议，定义负载均衡的类不要放在SpringBoot主类所在的包及其子包下
 * 使用方法：
 *      1.将实现了IRule接口的类通过@Bean交由Spring容器管理
 *      2.在RestTemplate接口加上@LoadBalanced注解，表明使用负载均衡
 *      3.在主启动类加上注解@RibbonClient(name = "服务名", configuration = RibbonRuleConfig.class)
 *      这样RestTemplate在调用时会通过服务名去查找对应的服务，按照IRule中的choose逻辑去选出相应服务
 */
@Configuration
public class RibbonRuleConfig {

//    不可同时写上两个IRule的子类，否则无法确定使用哪一个IRule
//    @Bean
//    public IRule getRandomRule() {
//        return new RandomRule();//定义为随机
//    }

    @Bean
    public IRule getMyRule() {
        return new MyRule();
    }
}
