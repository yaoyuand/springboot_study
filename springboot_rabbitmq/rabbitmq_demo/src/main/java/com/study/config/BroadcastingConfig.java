package com.study.config;

import com.study.message.BroadcastMessage;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 广播消费(订阅)
 * @Author ytj
 * @Date 2021/3/24 17:11
 */
@Configuration
public class BroadcastingConfig {

    @Bean
    public TopicExchange BroadcastingExchange(){
        return new TopicExchange(BroadcastMessage.EXCHANGE,true,false);
    }
}
