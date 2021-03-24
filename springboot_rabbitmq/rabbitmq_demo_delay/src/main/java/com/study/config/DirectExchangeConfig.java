package com.study.config;

import com.study.message.Demo08Message;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ytj
 * @Date 2021/3/24 15:13
 */
@Configuration
public class DirectExchangeConfig {
    @Bean
    public Queue demo08Queue(){
        return QueueBuilder.durable(Demo08Message.QUEUE)// durable: 是否持久化
                .autoDelete()// autoDelete: 是否自动删除
                .exclusive()// exclusive: 是否排它
                .ttl(10 * 1000)// 设置队列里的默认过期时间为 10 秒
                .deadLetterRoutingKey(Demo08Message.DELAY_ROUTING_KEY)
                .deadLetterExchange(Demo08Message.EXCHANGE)
                .build();
    }

    @Bean
    public Queue demo08DelayQueue(){
        return new Queue(Demo08Message.DELAY_QUEUE,// Queue 名字
                true,// durable: 是否持久化
                false,// exclusive: 是否排它
                false);// autoDelete: 是否自动删除
    }

    @Bean
    public DirectExchange demo08Exchange(){
        return new DirectExchange(Demo08Message.EXCHANGE,
                true,// durable: 是否持久化
                false);// exclusive: 是否排它
    }

    @Bean
    public Binding demo08Binding(){
        return BindingBuilder.bind(demo08Queue()).to(demo08Exchange()).with(Demo08Message.ROUTING_KEY);
    }

    @Bean
    public Binding demo08DelayBinding(){
        return BindingBuilder.bind(demo08DelayQueue()).to(demo08Exchange()).with(Demo08Message.DELAY_ROUTING_KEY);
    }

}
