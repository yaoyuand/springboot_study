package com.study.consumer;

import com.study.message.BroadcastMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 第一点，在 @Queue 注解的 name 属性，我们通过 Spring EL 表达式，在 Queue 的名字上，
 * 使用 UUID 生成其后缀。这样，我们就能保证每个项目启动的 Consumer 的 Queue 不同，以达到广播消费的目的。
 * 第二点，在 @Queue 注解的 autoDelete 属性，我们设置为 "true" ，这样在 Consumer 关闭时，
 * 该队列就可以被自动删除了
 * @Author ytj
 * @Date 2021/3/24 17:15
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(
                        name = BroadcastMessage.QUEUE+"-"+"#{T(java.util.UUID).randomUUID()}",
                        autoDelete = "true"
                ),
                exchange = @Exchange(
                        name = BroadcastMessage.EXCHANGE,
                        type = ExchangeTypes.TOPIC,
                        declare = "false"
                )
        )
)
public class BroadcastConsumer2 {
    private Logger logger= LoggerFactory.getLogger(BroadcastConsumer2.class);

    @RabbitHandler
    public void onmessage(BroadcastMessage message){
        logger.info("[BroadcastConsumer2.onmessage][线程编号:{},消息内容:{}]",Thread.currentThread().getId(),message);
    }
}
