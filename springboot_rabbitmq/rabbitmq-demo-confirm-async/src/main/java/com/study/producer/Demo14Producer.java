package com.study.producer;

import com.study.message.Demo14Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/25 14:51
 */
@Component
public class Demo14Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void synsend(Integer id){
        Demo14Message demo14Message=new Demo14Message();
        demo14Message.setId(id);
        this.rabbitTemplate.convertAndSend(Demo14Message.EXCHANGE,Demo14Message.ROUTING_KEY,demo14Message);
    }

    public void synsends(Integer id){
        Demo14Message demo14Message=new Demo14Message();
        demo14Message.setId(id);
        this.rabbitTemplate.convertAndSend(Demo14Message.EXCHANGE,"error",demo14Message);
    }
}
