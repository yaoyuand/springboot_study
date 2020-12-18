package com.sutdy;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class RpcProvider3Application {

    public static void main(String[] args) {
        SpringApplication.run(RpcProvider3Application.class, args);
    }

}
