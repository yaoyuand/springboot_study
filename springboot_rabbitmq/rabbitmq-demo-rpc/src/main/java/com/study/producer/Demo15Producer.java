package com.study.producer;

import com.study.message.Demo15Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Author ytj
 * @Date 2021/3/22 16:26
 */
@Component
public class Demo15Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncsend(Integer id){
        Demo15Message demo1Message=new Demo15Message();
        demo1Message.setId(id);
        CorrelationData correlationData=new CorrelationData(UUID.randomUUID().toString());
        this.rabbitTemplate.convertAndSend(Demo15Message.EXCHANGE,Demo15Message.ROUTING_KEY,demo1Message,correlationData);

    }


}
