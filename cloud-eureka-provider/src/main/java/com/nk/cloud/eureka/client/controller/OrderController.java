package com.nk.cloud.eureka.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2017/10/17.
 */
@RestController
public class OrderController {

    @RequestMapping("/orders")
    public String getOrder(){
        System.out.println("this is order list info");

        return "this info from first provider";
    }
}
