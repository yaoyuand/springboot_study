package com.study.controller;

import com.study.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注意:在服务消费者调用成功之后，哪怕注册中心挂了，服务消费者依然能调用成功，因为本地还具有缓存
 * dubbo还可以通过直连方式调用远程接口 如:@Reference(url = "dubbo://localhost:20890")
 * */
@RestController
public class UserController {


    @Reference(version = "1.0",stub = "com.study.controller.DoService")
    private UserService userService;

    @RequestMapping("/all")
    public Object all(){
        System.out.println("执行服务消费者");
        return this.userService.selectAll();
    }
}
