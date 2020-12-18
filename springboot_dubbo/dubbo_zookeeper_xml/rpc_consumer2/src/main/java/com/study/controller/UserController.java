package com.study.controller;

import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {
    /**
     * 这边必须要添加spring的autowired或者resource注解
     */
    @Autowired
    private UserService userService;

    @RequestMapping("/all")
    public Object all(){
        return userService.selectAll();
    }
}
