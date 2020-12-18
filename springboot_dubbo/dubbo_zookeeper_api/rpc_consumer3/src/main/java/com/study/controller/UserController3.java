package com.study.controller;

import com.study.service.UserService3;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController3 {
    @Reference
    private UserService3 userService3;

    @RequestMapping("/all")
    public Object all(){
        System.out.println("执行服务消费方法");
        return userService3.selectAll();
    }
}
