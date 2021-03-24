package com.study.consumer;

import com.study.message.Demo1Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @Author ytj
 * @Date 2021/3/22 16:34
 */
@Component
@RabbitListener(queues = Demo1Message.QUEUE)
public class Demo1Consumer {
    private Logger logger= LoggerFactory.getLogger(getClass());

    @RabbitHandler
    public void onmessage(Demo1Message demo1Message){
        logger.info("[onMessage][线程编号:{}消息内容{}]",Thread.currentThread().getId(),demo1Message);
    }
}
