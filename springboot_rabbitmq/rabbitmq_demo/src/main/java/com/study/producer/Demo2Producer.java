package com.study.producer;

import com.study.message.Demo2Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/23 16:54
 */
@Component
public class Demo2Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncsend(Integer id,String routingkey){
        Demo2Message demo2Message=new Demo2Message();
        demo2Message.setId(id);
        this.rabbitTemplate.convertAndSend(Demo2Message.EXCHANGE,routingkey,demo2Message);
    }
}
