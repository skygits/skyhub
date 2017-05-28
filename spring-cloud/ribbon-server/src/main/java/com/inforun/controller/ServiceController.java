package com.inforun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yakai.wang on 2017/5/11.
 * Service1项目设置负载均衡
 */
@RestController
//@RibbonClient
public class ServiceController {
    @Autowired
    private RestTemplate restTemplate;

    /*@GetMapping(value = "/ribbon")
    public String find(){
        return restTemplate.getForObject("http://calendar-system/calendar-system/helloword",String.class);
    }*/
    /*@Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/calendar-system")
    public void calendar(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("calendar-system");
    }*/
    @GetMapping("/service1")
    public String test(){
        return restTemplate.getForObject("http://service1/user", String.class);
    }
}

