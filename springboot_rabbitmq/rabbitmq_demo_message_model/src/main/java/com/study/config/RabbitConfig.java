package com.study.config;

import com.study.message.ClusteringMessage;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息模式:集群消费(点对点)
 * @Author ytj
 * @Date 2021/3/24 16:32
 */
@Configuration
public class RabbitConfig {

    //这边使用topExchange主要原因是 Spring Cloud Stream RabbitMQ默认是使用 Topic Exchange 的
    @Bean
    public TopicExchange clusteringExchange(){
        return new TopicExchange(ClusteringMessage.EXCHANGE,
                true,//是否持久化
                false);//是否自动删除
    }
}
