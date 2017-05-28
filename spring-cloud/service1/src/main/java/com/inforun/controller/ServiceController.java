package com.inforun.controller;

import com.inforun.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yakai.wang on 2017/5/12.
 */
@RestController
public class ServiceController {

    @RequestMapping("/user")
    public User getUser(){
        User user  = new User();
        user.setName("zhangsan");
        user.setPassword("123456");
        user.setAge("78");
        System.out.println("user 123456789");
        return user;
    }
}
