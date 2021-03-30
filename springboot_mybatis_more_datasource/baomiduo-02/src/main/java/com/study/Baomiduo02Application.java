package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan(basePackages = "com.study.mapper")
//Spring AOP 能将当前代理对象设置到 AopContext 中
@EnableAspectJAutoProxy
public class Baomiduo02Application {

    public static void main(String[] args) {
        SpringApplication.run(Baomiduo02Application.class, args);
    }

}
