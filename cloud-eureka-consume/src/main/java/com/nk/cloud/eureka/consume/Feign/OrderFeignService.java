package com.nk.cloud.eureka.consume.Feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 2017/10/17.
 */

@FeignClient(name = "firstCloudEurekaProvider")
public interface OrderFeignService {

    @RequestMapping("/orders")
    String getOrder();
}
