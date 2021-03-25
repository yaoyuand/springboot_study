package com.study.consumer;

import com.study.message.Demo11Message;
import com.study.producer.Demo11Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/25 11:14
 */
@Component
@RabbitListener(queues = Demo11Message.QUEUE)
public class Demo11Consumer {
    private Logger logger= LoggerFactory.getLogger(Demo11Consumer.class);

    @RabbitHandler
    public void onmessage(Demo11Message message){
        logger.info("[onmessage][线程编号:{},消息内容:{}]",Thread.currentThread().getId(),message);
    }
}
