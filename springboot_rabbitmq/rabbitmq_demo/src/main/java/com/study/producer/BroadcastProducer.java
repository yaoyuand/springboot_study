package com.study.producer;

import com.study.message.BroadcastMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/24 17:13
 */
@Component
public class BroadcastProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void synSend(Integer id){
        BroadcastMessage broadcastMessage=new BroadcastMessage();
        broadcastMessage.setId(id);
        this.rabbitTemplate.convertAndSend(BroadcastMessage.EXCHANGE,null,broadcastMessage);
    }
}
