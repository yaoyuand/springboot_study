package com.study.producer;

import com.study.message.Demo07Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/24 14:34
 */
@Component
public class Demo07Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void synSend(Integer id){
        Demo07Message demo07Message=new Demo07Message();
        demo07Message.setId(id);
        this.rabbitTemplate.convertAndSend(Demo07Message.EXCHANGE,Demo07Message.ROUTING_KEY,demo07Message);
    }
}
