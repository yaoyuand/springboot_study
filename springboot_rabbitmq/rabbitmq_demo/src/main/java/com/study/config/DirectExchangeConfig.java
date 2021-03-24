package com.study.config;

import com.study.message.Demo1Message;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Direct 类型的 Exchange 路由规则比较简单，它会把消息路由到那些 binding key 与 routing key 完全匹配的 Queue 中
 * @Author ytj
 * @Date 2021/3/22 15:58
 */
@Configuration
public class DirectExchangeConfig {
    @Bean
    public Queue queueDemo1(){
        return new Queue(Demo1Message.QUEUE,
                true,//durable:是否持久化
                true,//exclusive:是否排他
                false);//autoDelete：是否自动删除
    }

    @Bean
    public DirectExchange exchangeDemo1(){
        return new DirectExchange(Demo1Message.EXCHANGE,
                true,//durable:是否持久化
                false);//autoDelete：是否自动删除
    }

    @Bean
    public Binding demo01Binding() {
        return BindingBuilder.bind(queueDemo1()).to(exchangeDemo1()).with(Demo1Message.ROUTING_KEY);
    }
}
