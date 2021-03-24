package com.study.producer;

import com.study.message.Demo4Message;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/23 18:26
 */
@Component
public class Demo4Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void synsend(Integer id,String heardValue){
        //创建MessageProperties属性
        MessageProperties messageProperties=new MessageProperties();
        messageProperties.setHeader(Demo4Message.HEARD_KEY,heardValue);
        Demo4Message demo4Message=new Demo4Message();
        demo4Message.setId(id);
        //创建message消息
        Message message=this.rabbitTemplate.getMessageConverter().toMessage(demo4Message,messageProperties);
        //发送消息
        this.rabbitTemplate.send(Demo4Message.EXCHANGE,null,message);
    }
}
