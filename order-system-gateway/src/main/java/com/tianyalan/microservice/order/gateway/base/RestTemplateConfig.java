package com.tianyalan.microservice.order.gateway.base;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//@RibbonClient("PRODUCT")  // 必須添加！
public class RestTemplateConfig {

    @Bean
//    @LoadBalanced // 必須添加！
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
