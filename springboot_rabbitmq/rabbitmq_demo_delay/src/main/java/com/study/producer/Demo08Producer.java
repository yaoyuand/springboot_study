package com.study.producer;

import com.study.message.Demo08Message;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/24 15:21
 */
@Component
public class Demo08Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void synSend(Integer id,Integer delay){
        Demo08Message demo08Message=new Demo08Message();
        demo08Message.setId(id);
        rabbitTemplate.convertAndSend(Demo08Message.EXCHANGE, Demo08Message.ROUTING_KEY, demo08Message, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                if(delay!=null&&delay>0){
                    message.getMessageProperties().setExpiration(String.valueOf(delay));
                }
                return message;
            }
        });
    }
}
