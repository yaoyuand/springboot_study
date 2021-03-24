package com.study.config;

import com.study.message.Demo5Message;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.batch.BatchingStrategy;
import org.springframework.amqp.rabbit.batch.SimpleBatchingStrategy;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

/**
 * 批量发送消息
 * @Author ytj
 * @Date 2021/3/24 10:11
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue demo5Queue(){
        return new Queue(Demo5Message.QUEUE,
                true,//是否持久化
                false,//是否排他
                false);//是否自动删除
    }

    @Bean
    public DirectExchange demo5Exchange(){
        return new DirectExchange(Demo5Message.EXCHANGE,true,false);
    }

    @Bean
    public Binding demo5Binding(){
        return BindingBuilder.bind(demo5Queue()).to(demo5Exchange()).with(Demo5Message.ROUTING_KEY);
    }

    @Bean
    public BatchingRabbitTemplate batchingRabbitTemplate(ConnectionFactory connectionFactory){
        //创建batchingstrategy对象，代表批量策略
        int batchSize=16384;//超过收集消息数量的最大条数
        int bufferLimit=33554432;//每次批量发送消息最大内存
        int timeout=3000;//超过收集时间的最大等待时间(每次消息之间间隔)，单位：毫秒
        BatchingStrategy batchingStrategy=new SimpleBatchingStrategy(batchSize,bufferLimit,timeout);
        //创建TaskScheduler对象，用于实现超时发送定时器
        TaskScheduler taskScheduler=new ConcurrentTaskScheduler();
        //创建BatchingRabbitTemplate对象
        BatchingRabbitTemplate batchingRabbitTemplate=new BatchingRabbitTemplate(batchingStrategy,taskScheduler);
        batchingRabbitTemplate.setConnectionFactory(connectionFactory);
        return batchingRabbitTemplate;
    }
}
