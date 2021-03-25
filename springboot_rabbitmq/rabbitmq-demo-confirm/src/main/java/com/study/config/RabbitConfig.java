package com.study.config;

import com.study.message.Demo13Message;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 同步 Confirm 模式
 * @Author ytj
 * @Date 2021/3/25 10:51
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue queueDemo13(){
        return new Queue(Demo13Message.QUEUE,true,false,false);
    }

    @Bean
    public DirectExchange exchangeDemo13(){
        return new DirectExchange(Demo13Message.EXCHANGE,true,false);
    }

    @Bean
    public Binding bindingDemo13(){
        return BindingBuilder.bind(queueDemo13()).to(exchangeDemo13()).with(Demo13Message.ROUTING_KEY);
    }


}
