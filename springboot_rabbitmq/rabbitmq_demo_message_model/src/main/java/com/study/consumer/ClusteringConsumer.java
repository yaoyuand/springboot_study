package com.study.consumer;

import com.study.message.ClusteringMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 在 bindings 属性，我们添加了 @QueueBinding 注解，来定义了一个 Binding 。通过 key 属性，
 * 设置使用的 RoutingKey 为 # ，匹配所有。
 * 这就是为什么我们在ClusteringMessage未定义 RoutingKey ，
 * 以及在ClusteringProducer中使用 routingKey = null 的原因。
 * 在 exchange 属性，我们添加了 @Exchange 注解，设置了对应 EXCHANGE_CLUSTERING 这个 Exchange 。
 * type 属性，设置是 TopicExchange 。
 * declare 属性，因为 RabbitConfig中，已经配置创建这个 Exchange 了。
 * 在 value 属性，我们添加了 @Queue 注解，设置消费 QUEUE_CLUSTERING-GROUP-01 这个 Queue 的消息。
 * 注意，通过添加 @Exchange、@Queue、@QueueBinding 注解，
 * 如果未声明 declare="false" 时，会自动创建对应的 Exchange、Queue、Binding 。
 * @Author ytj
 * @Date 2021/3/24 16:50
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(
                        name= ClusteringMessage.QUEUE+"-"+"GROUP-01"
                ),
                exchange = @Exchange(
                        name = ClusteringMessage.EXCHANGE,
                        type = ExchangeTypes.TOPIC,
                        declare = "false"
                ),
                key = "#"
        )
)
public class ClusteringConsumer {
    private Logger logger= LoggerFactory.getLogger(ClusteringConsumer.class);

    @RabbitHandler
    public void onmessage(ClusteringMessage message){
        logger.info("[onmessage][线程编号:{},消息内容:{}]",Thread.currentThread().getId(),message);
    }
}
