package com.study.confirm;

import com.study.message.Demo14Message;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 异步 Confirm 模式
 * @Author ytj
 * @Date 2021/3/25 10:51
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue queueDemo14(){
        return new Queue(Demo14Message.QUEUE,true,false,false);
    }

    @Bean
    public DirectExchange exchangeDemo14(){
        return new DirectExchange(Demo14Message.EXCHANGE,true,false);
    }

    @Bean
    public Binding bindingDemo14(){
        return BindingBuilder.bind(queueDemo14()).to(exchangeDemo14()).with(Demo14Message.ROUTING_KEY);
    }


}
