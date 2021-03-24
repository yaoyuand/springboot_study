package com.study.producer;

import com.study.message.Demo1Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @Author ytj
 * @Date 2021/3/22 16:26
 */
@Component
public class Demo1Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncsend(Integer id){
        Demo1Message demo1Message=new Demo1Message();
        demo1Message.setId(id);
        this.rabbitTemplate.convertAndSend(Demo1Message.EXCHANGE,Demo1Message.ROUTING_KEY,demo1Message);

    }

    public void syncsendDefault(Integer id){
        Demo1Message demo1Message=new Demo1Message();
        demo1Message.setId(id);
        this.rabbitTemplate.convertAndSend(Demo1Message.QUEUE,demo1Message);
    }

    @Async
    public ListenableFuture<Void> asyncsend(Integer id){
        try {
            this.syncsend(id);
            return AsyncResult.forValue(null);
        } catch (Exception e) {
            return AsyncResult.forExecutionException(e);
        }

    }
}
