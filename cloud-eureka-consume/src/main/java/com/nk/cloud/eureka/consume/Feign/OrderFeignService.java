package com.nk.cloud.eureka.consume.Feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 2017/10/17.
 *
 * Spring Cloud应用在启动时，Feign会扫描标有@FeignClient注解的接口，生成代理，并注册到Spring容器中。
 * 生成代理时Feign会为每个接口方法创建一个RequetTemplate对象，
 * 该对象封装了HTTP请求需要的全部信息，请求参数名、请求方法等信息都是在这个过程中确定的，Feign的模板化就体现在这里。
 */

@FeignClient(name = "firstCloudEurekaProvider",fallbackFactory = OrderFeignFallback.class)
public interface OrderFeignService {

    @RequestMapping("/orders")
    String getOrder();
}
