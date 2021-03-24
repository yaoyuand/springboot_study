package com.study.consumer;

import com.study.message.Demo2Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/23 16:57
 */
@Component
@RabbitListener(queues = Demo2Message.QUEUE)
public class Demo2Consumer {

    private Logger logger= LoggerFactory.getLogger(Demo2Consumer.class);

    @RabbitHandler
    public void onmessage(Demo2Message demo2Message){
        logger.info("[onmessage],[线程编号:{},消息内容:{}]",Thread.currentThread().getId(),demo2Message);
    }
}
