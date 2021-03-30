package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan(basePackages = "com.study.mapper")
@EnableAspectJAutoProxy
public class DatasourceShardingJdbc01Application {

    public static void main(String[] args) {
        SpringApplication.run(DatasourceShardingJdbc01Application.class, args);
    }

}
