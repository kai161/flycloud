package com.nk.cloud.eureka.consume.Feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Created on 2017/10/18.
 */
@Component
public class OrderFeignFallback implements FallbackFactory<OrderFeignService> {
    @Override
    public OrderFeignService create(Throwable throwable) {
        return new OrderFeignService(){

            @Override
            public String getOrder() {
                return "this is getOrder fallback massage:"+throwable.getMessage();
            }
        };
    }
}
