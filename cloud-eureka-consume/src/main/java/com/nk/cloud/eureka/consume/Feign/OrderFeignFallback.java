package com.nk.cloud.eureka.consume.Feign;

import feign.hystrix.FallbackFactory;

/**
 * Created on 2017/10/18.
 */
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
