package com.study.confirm;

import com.study.message.Demo15Message;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 同步 rpc 模式
 * @Author ytj
 * @Date 2021/3/25 10:51
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue queueDemo15(){
        return new Queue(Demo15Message.QUEUE,true,false,false);
    }

    @Bean
    public DirectExchange exchangeDemo15(){
        return new DirectExchange(Demo15Message.EXCHANGE,true,false);
    }

    @Bean
    public Binding bindingDemo15(){
        return BindingBuilder.bind(queueDemo15()).to(exchangeDemo15()).with(Demo15Message.ROUTING_KEY);
    }


}
