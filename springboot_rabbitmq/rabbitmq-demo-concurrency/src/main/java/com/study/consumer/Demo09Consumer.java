package com.study.consumer;

import com.study.message.Demo09Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/24 18:11
 */
@Component
@RabbitListener(queues = Demo09Message.QUEUE,concurrency = "2")
public class Demo09Consumer {
    private Logger logger= LoggerFactory.getLogger(Demo09Consumer.class);

    @RabbitHandler
    public void onmessage(Demo09Message message){
        logger.info("[onmessage][线程编号:{},消息内容:{}]",Thread.currentThread().getId(),message);
    }
}


