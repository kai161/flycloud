package com.nk.cloud.eureka.consume.Controller;

import com.nk.cloud.eureka.consume.Feign.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2017/10/17.
 */
@RestController
public class FeignConsumeController {

    @Autowired
    private OrderFeignService orderFeignService;

    @RequestMapping("/orderlist")
    public String getOrderList(){

        return "feign "+orderFeignService.getOrder();
    }
}
