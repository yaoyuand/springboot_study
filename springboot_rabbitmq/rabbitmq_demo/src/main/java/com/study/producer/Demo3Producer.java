package com.study.producer;

import com.study.message.Demo03Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/23 17:43
 */
@Component
public class Demo3Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void synsend(Integer id){
        Demo03Message demo03Message=new Demo03Message();
        demo03Message.setId(id);
        this.rabbitTemplate.convertAndSend(Demo03Message.EXCHANGE,null,demo03Message);
    }
}
