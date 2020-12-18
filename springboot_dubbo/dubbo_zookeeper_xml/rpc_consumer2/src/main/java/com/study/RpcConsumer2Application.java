package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:dubbo.xml")
@SpringBootApplication
public class RpcConsumer2Application {

    public static void main(String[] args) {
        SpringApplication.run(RpcConsumer2Application.class, args);
    }

}
