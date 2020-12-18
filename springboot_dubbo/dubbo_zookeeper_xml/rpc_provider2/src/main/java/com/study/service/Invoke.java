package com.study.service;

import org.springframework.stereotype.Service;

@Service
public class Invoke {
    public void invoke(){
        System.out.println("方法执行之前拦截");
    }

    public void returns(){
        System.out.println("方法执行之后拦截");
    }
}
