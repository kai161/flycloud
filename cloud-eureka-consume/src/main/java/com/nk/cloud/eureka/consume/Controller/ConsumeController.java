package com.nk.cloud.eureka.consume.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created on 2017/10/17.
 */
@RestController
public class ConsumeController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/orderinfo")
    public String getOrderInfo(){

        List<ServiceInstance> list=discoveryClient.getInstances("firstCloudEurekaProvider");

        String url=null;
        if(list!=null&&list.size()>0){
            url=String.valueOf(list.get(0).getUri());
        }

        String result=(String)restTemplate.getForObject(url+"/orders",String.class);


        return result;
    }
}
