package com.study.consumer;

import com.study.message.Demo16Message;
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
@RabbitListener(queues = Demo16Message.QUEUE,
        errorHandler = "rabbitListenerErrorHandler")
public class Demo16Consumer {
    private Logger logger= LoggerFactory.getLogger(getClass());

    @RabbitHandler
    public void onmessage(Demo16Message demo1Message){
        logger.info("[onMessage][线程编号:{}消息内容{}]",Thread.currentThread().getId(),demo1Message);
        // 模拟消费异常
        throw new RuntimeException("你猜");
    }
}
