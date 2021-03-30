package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan(basePackages = "com.study.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)//希望 Spring AOP 能将当前代理对象设置到 AopContext 中
public class Baomiduo01Application {

    public static void main(String[] args) {
        SpringApplication.run(Baomiduo01Application.class, args);
    }

}
