package com.nk.cloud.eureka.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 2017/10/17.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CloudEurekaConsume {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaConsume.class,args);
    }
}
