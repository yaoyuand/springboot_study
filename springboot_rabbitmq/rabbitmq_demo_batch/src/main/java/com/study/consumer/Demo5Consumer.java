package com.study.consumer;

import com.study.message.Demo5Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/24 10:26
 */
@Component
@RabbitListener(queues = Demo5Message.QUEUE)
public class Demo5Consumer {

    private Logger logger= LoggerFactory.getLogger(Demo5Consumer.class);

    @RabbitHandler
    public void onmessage(Demo5Message demo5Message){
        logger.info("[onmessage],[线程编号:{},消息内容:{}]",Thread.currentThread().getId(),demo5Message);
    }
}
