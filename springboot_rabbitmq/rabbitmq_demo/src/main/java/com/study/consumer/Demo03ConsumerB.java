package com.study.consumer;

import com.study.message.Demo03Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/23 17:49
 */
@Component
@RabbitListener(queues = Demo03Message.QUEUE_B)
public class Demo03ConsumerB {
    private Logger logger= LoggerFactory.getLogger(Demo03ConsumerB.class);

    @RabbitHandler
    public void onmessage(Demo03Message demo03Message){
        logger.info("[onmessage],线程编号:{},消息内容:{}",Thread.currentThread().getId(),demo03Message);
    }
}
