package com.study.consumer;

import com.study.message.Demo13Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/25 11:28
 */
@Component
@RabbitListener(queues = Demo13Message.QUEUE)
public class Demo13Consumer {
    private Logger logger= LoggerFactory.getLogger(Demo13Message.class);

    @RabbitHandler
    public void onmessage(Demo13Message message) {
        logger.info("[onmessage][线程编号:{} 消息内容：{}]",Thread.currentThread().getId(),message);

    }
}
