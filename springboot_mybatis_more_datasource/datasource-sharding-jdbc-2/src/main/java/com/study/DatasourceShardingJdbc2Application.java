package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScan(basePackages = "com.study.mapper")
public class DatasourceShardingJdbc2Application {

    public static void main(String[] args) {
        SpringApplication.run(DatasourceShardingJdbc2Application.class, args);
    }

}
