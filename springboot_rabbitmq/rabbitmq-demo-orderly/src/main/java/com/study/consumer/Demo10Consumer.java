package com.study.consumer;

import com.study.message.Demo10Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/24 23:19
 */
@Component
@RabbitListener(queues = Demo10Message.QUEUE_0)
@RabbitListener(queues = Demo10Message.QUEUE_1)
@RabbitListener(queues = Demo10Message.QUEUE_2)
@RabbitListener(queues = Demo10Message.QUEUE_3)
public class Demo10Consumer {
    private Logger logger= LoggerFactory.getLogger(Demo10Consumer.class);

    /**
     * 这边使用message就必须要将isDefault设置为true否则会报错
     * */
    @RabbitHandler(isDefault = true)
    public void onmessage(Message<Demo10Message> message){
        logger.info("[onmessage][线程编号:{},queue:{},消息内容:{}]",Thread.currentThread().getId(),getKey(message),message.getPayload().getId());
    }

    private String getKey(Message<Demo10Message> message){
        return message.getHeaders().get("amqp_consumerQueue", String.class);
    }
}
