package com.study.controller;

import com.study.entity.User;
import com.study.service.UserService;

import java.util.List;

public class DoService implements UserService{
    private UserService userService;

    public DoService(UserService userService){
        this.userService=userService;
    }

    /**
     * dubbo中的本地存根方法
     * 会在dubbo调用远程服务之前执行，类似于前置通知,必须要提供对应的构造器
     * */
    public List<User> selectAll(){
        System.out.println("本地存根方法被调用");
        return this.userService.selectAll();
    }
}
