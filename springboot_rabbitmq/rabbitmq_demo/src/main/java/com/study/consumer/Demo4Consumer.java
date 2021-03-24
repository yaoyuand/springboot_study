package com.study.consumer;

import com.study.message.Demo4Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/23 18:33
 */
@Component
@RabbitListener(queues = Demo4Message.QUEUE)
public class Demo4Consumer {

    private Logger logger= LoggerFactory.getLogger(Demo4Consumer.class);

    @RabbitHandler
    public void onmessage(Demo4Message demo4Message){
        logger.info("[onmessage],线程编号:{},消息内容:{}",Thread.currentThread().getId(),demo4Message);
    }
}
