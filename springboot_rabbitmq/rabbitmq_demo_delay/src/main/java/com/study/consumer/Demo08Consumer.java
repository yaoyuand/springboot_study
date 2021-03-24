package com.study.consumer;

import com.study.message.Demo08Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/24 15:26
 */
@Component
@RabbitListener(queues = Demo08Message.DELAY_QUEUE)
public class Demo08Consumer {
    private Logger logger= LoggerFactory.getLogger(Demo08Consumer.class);

    @RabbitHandler
    public void onmessage(Demo08Message message){
        this.logger.info("[onmessage][线程编号:{},消息内容:{}]",Thread.currentThread().getId(),message);
    }
}
