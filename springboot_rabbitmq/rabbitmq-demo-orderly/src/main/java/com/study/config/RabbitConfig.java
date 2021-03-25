package com.study.config;

import com.study.message.Demo10Message;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息队列(示例通过将相同队列消息发送到相同的队列里面，
 * 从而实现普通顺序消息，并没有实现严格的消费顺序)
 * 最终结果为将相同的消息发送到相同的队列被相同的线程接收
 * @Author ytj
 * @Date 2021/3/24 23:11
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queueDemo0(){
        return new Queue(Demo10Message.QUEUE_0,true,false,false);
    }
    @Bean
    public Queue queueDemo1(){
        return new Queue(Demo10Message.QUEUE_1,true,false,false);
    }
    @Bean
    public Queue queueDemo2(){
        return new Queue(Demo10Message.QUEUE_2,true,false,false);
    }
    @Bean
    public Queue queueDemo3(){
        return new Queue(Demo10Message.QUEUE_3,true,false,false);
    }

    @Bean
    public DirectExchange exchangeDemo10(){
        return new DirectExchange(Demo10Message.EXCHANGE,true,false);
    }

    @Bean
    public Binding bindingDemo0(){
        return BindingBuilder.bind(queueDemo0()).to(exchangeDemo10()).with("0");
    }
    @Bean
    public Binding bindingDemo1(){
        return BindingBuilder.bind(queueDemo1()).to(exchangeDemo10()).with("1");
    }
    @Bean
    public Binding bindingDemo2(){
        return BindingBuilder.bind(queueDemo2()).to(exchangeDemo10()).with("2");
    }
    @Bean
    public Binding bindingDemo3(){
        return BindingBuilder.bind(queueDemo3()).to(exchangeDemo10()).with("3");
    }
}
