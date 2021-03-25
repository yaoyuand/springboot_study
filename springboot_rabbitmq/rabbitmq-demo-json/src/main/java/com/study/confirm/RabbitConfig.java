package com.study.confirm;

import com.study.message.Demo16Message;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息转换
 * @Author ytj
 * @Date 2021/3/25 10:51
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue queueDemo16(){
        return new Queue(Demo16Message.QUEUE,true,false,false);
    }

    @Bean
    public DirectExchange exchangeDemo16(){
        return new DirectExchange(Demo16Message.EXCHANGE,true,false);
    }

    @Bean
    public Binding bindingDemo16(){
        return BindingBuilder.bind(queueDemo16()).to(exchangeDemo16()).with(Demo16Message.ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }



}
