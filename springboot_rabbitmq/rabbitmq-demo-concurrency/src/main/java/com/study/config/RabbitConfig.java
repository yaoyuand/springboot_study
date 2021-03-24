package com.study.config;

import com.study.message.Demo09Message;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 并发消费
 * @Author ytj
 * @Date 2021/3/24 18:06
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue demo09Queue(){
        return new Queue(Demo09Message.QUEUE,
                true,
                true,
                false);
    }


    @Bean
    public DirectExchange demo09Exchange(){
        return new DirectExchange(Demo09Message.EXCHANGE,true,false);
    }

    @Bean
    public Binding demo09Binding(){
        return BindingBuilder.bind(demo09Queue()).to(demo09Exchange()).with(Demo09Message.ROUTING_KEY);
    }




}
