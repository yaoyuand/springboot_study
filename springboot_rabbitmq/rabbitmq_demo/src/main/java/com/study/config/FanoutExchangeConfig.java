package com.study.config;

import com.study.message.Demo03Message;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * fanout exchange路由规则非常简单，它会把发送到该exchange的消息路由到所有与它绑定的queue中
 * queue:消息队列
 * exchange:消息交换机，指定消息按照什么规则路由到什么队列
 * binding:绑定，将queue和exchange按照路由规则绑定起来
 * @Author ytj
 * @Date 2021/3/23 17:20
 */
@Configuration
public class FanoutExchangeConfig {
    @Bean
    public Queue demo03QueueA(){
        return new Queue(Demo03Message.QUEUE_A,//队列名称
                true,//是否持久化
                false,//是否排他
                false);//是否自动删除
    }

    @Bean
    public Queue demo03QueueB(){
        return new Queue(Demo03Message.QUEUE_B,//队列名称
                true,//是否持久化
                false,//是否排他
                false);//是否自动删除
    }

    @Bean
    public FanoutExchange demo03Exchange(){
        return new FanoutExchange(Demo03Message.EXCHANGE,
                true,//是否持久化
                false);//是否自动删除
    }

    @Bean
    public Binding demo03ABinding(){
        return BindingBuilder.bind(demo03QueueA()).to(demo03Exchange());
    }

    @Bean
    public Binding demo03BBinding(){
        return BindingBuilder.bind(demo03QueueB()).to(demo03Exchange());
    }
}
