package com.study.controller;

import com.study.entity.User;
import com.study.service.UserService;

import java.util.List;
import java.util.Random;

public class UserServiceStub implements UserService {
    private UserService userService;

    public UserServiceStub(UserService userService){
        this.userService=userService;
    }
    @Override
    public List<User> selectAll() {
        System.out.println("执行存根方法");
        double num=Math.random();
        System.out.println("num:"+num);
        if(num>0.5){
            System.out.println("调用远程方法");
            return userService.selectAll();
        }else{
            System.out.println("未调用远程方法");
            return null;
        }
    }
}
