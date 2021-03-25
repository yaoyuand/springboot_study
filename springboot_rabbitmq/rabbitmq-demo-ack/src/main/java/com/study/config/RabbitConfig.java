package com.study.config;

import com.study.message.Demo12Message;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *在 RabbitMQ 中，Consumer 有两种消息确认的方式：
 * 方式一，自动确认。
 * 方式二，手动确认。
 * 自动确认:RabbitMQ Broker 只要将消息写入到 TCP Socket 中成功，就认为该消息投递成功，而无需 Consumer 手动确认。
 * 手动确认:RabbitMQ Broker 将消息发送给 Consumer 之后，由 Consumer 手动确认之后，才任务消息投递成功
 *
 * 实际场景下，因为自动确认存在可能丢失消息的情况，所以在对可靠性有要求的场景下，我们基本采用手动确认。
 * 当然，如果允许消息有一定的丢失，对性能有更高的产经下，我们可以考虑采用自动确认
 *
 * @Author ytj
 * @Date 2021/3/25 10:51
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue queueDemo12(){
        return new Queue(Demo12Message.QUEUE,true,false,false);
    }

    @Bean
    public DirectExchange exchangeDemo12(){
        return new DirectExchange(Demo12Message.EXCHANGE,true,false);
    }

    @Bean
    public Binding bindingDemo12(){
        return BindingBuilder.bind(queueDemo12()).to(exchangeDemo12()).with(Demo12Message.ROUTING_KEY);
    }


}
