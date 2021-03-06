package com.study.producer;

import com.study.message.Demo16Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @Author ytj
 * @Date 2021/3/22 16:26
 */
@Component
public class Demo16Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncsend(Integer id){
        Demo16Message demo1Message=new Demo16Message();
        demo1Message.setId(id);
        this.rabbitTemplate.convertAndSend(Demo16Message.EXCHANGE,Demo16Message.ROUTING_KEY,demo1Message);

    }


}
