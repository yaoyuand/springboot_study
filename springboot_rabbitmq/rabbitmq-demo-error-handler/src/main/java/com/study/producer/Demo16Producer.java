package com.study.producer;

import com.study.message.Demo16Message;
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
public class Demo16Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncsend(Integer id){
        Demo16Message demo16Message=new Demo16Message();
        demo16Message.setId(id);
        CorrelationData correlationData=new CorrelationData(UUID.randomUUID().toString());
        this.rabbitTemplate.convertAndSend(Demo16Message.EXCHANGE,Demo16Message.ROUTING_KEY,demo16Message,correlationData);

    }


}
