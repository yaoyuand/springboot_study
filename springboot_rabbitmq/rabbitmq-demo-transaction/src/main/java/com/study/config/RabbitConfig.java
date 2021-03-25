package com.study.config;

import com.study.message.Demo11Message;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.transaction.RabbitTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 因为 Spring-AMQP 通过 RabbitTransactionManager 来实现对 Spring Transaction 的集成，
 * 所以在实际开发中，我们只需要配合使用 @Transactional 注解，来声明事务即可。
 * @Author ytj
 * @Date 2021/3/25 10:51
 */
@Configuration
//开启spring transaction支持
@EnableTransactionManagement
public class RabbitConfig {
    @Bean
    public Queue queueDemo11(){
        return new Queue(Demo11Message.QUEUE,true,false,false);
    }

    @Bean
    public DirectExchange exchangeDemo11(){
        return new DirectExchange(Demo11Message.EXCHANGE,true,false);
    }

    @Bean
    public Binding bindingDemo11(){
        return BindingBuilder.bind(queueDemo11()).to(exchangeDemo11()).with(Demo11Message.ROUTING_KEY);
    }

    @Bean
    public RabbitTransactionManager rabbitTransactionManager(ConnectionFactory connectionFactory,
                                                             RabbitTemplate rabbitTemplate){
        //设置rabbitTemplate支持事务
        rabbitTemplate.setChannelTransacted(true);
        //创建rabbitTransactionManager对象
        return new RabbitTransactionManager(connectionFactory);
    }
}
