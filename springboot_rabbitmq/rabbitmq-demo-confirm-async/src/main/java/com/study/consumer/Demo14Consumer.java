package com.study.consumer;

import com.study.message.Demo14Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/25 14:53
 */
@Component
@RabbitListener(queues = Demo14Message.QUEUE)
public class Demo14Consumer {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    public void onmessag(Demo14Message message){
        logger.info("[onmessag][线程编号:{},消息内容:{}]",Thread.currentThread().getId(),message);
    }
}
