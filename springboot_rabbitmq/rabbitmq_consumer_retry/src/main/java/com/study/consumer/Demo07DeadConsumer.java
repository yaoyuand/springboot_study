package com.study.consumer;

import com.study.message.Demo07Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/24 14:40
 */
@Component
@RabbitListener(queues = Demo07Message.DEAD_QUEUE)
public class Demo07DeadConsumer {
    private Logger logger= LoggerFactory.getLogger(Demo07DeadConsumer.class);

    @RabbitHandler
    public void onmessage(Demo07Message demo07Message){
        logger.info("[onmessage][【死信队列】线程编号:{},消息内容:{}]",Thread.currentThread().getId(),demo07Message);
    }
}
