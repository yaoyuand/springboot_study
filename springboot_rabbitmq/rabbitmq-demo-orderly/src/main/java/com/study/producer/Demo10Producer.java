package com.study.producer;

import com.study.message.Demo10Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/24 23:15
 */
@Component
public class Demo10Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void synsend(Integer id){
        Demo10Message demo10Message=new Demo10Message();
        demo10Message.setId(id);
        //同步发送消息
        this.rabbitTemplate.convertAndSend(Demo10Message.EXCHANGE,getRoutingKey(id),demo10Message);
    }

    private String getRoutingKey(Integer id){
        return String.valueOf(id % Demo10Message.QUEUE_COUNT);
    }
}
