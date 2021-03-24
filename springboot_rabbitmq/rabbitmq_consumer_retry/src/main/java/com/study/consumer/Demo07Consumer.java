package com.study.consumer;

import com.study.message.Demo07Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/24 14:36
 */
@Component
@RabbitListener(queues = Demo07Message.QUEUE)
public class Demo07Consumer {

    private Logger logger= LoggerFactory.getLogger(Demo07Consumer.class);

    @RabbitHandler
    public void onmessage(Demo07Message demo07Message){
        logger.info("[onmessage][线程编号:{},消息内容:{}]",Thread.currentThread().getId(),demo07Message);
        throw new RuntimeException("刻意模拟消费异常");
    }
}
