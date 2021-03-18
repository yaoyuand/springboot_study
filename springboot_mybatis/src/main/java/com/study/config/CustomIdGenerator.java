package com.study.config;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 设置id生成策略，也可以不配置采用默认的生成方式
 * @Author ytj
 * @Date 2021/3/10 17:05
 */
@Component
public class CustomIdGenerator implements IdentifierGenerator {
    @Override
    public Number nextId(Object entity) {
        DefaultIdentifierGenerator di=new DefaultIdentifierGenerator();
        return di.nextId(entity);
    }

    @Override
    public String nextUUID(Object entity) {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
