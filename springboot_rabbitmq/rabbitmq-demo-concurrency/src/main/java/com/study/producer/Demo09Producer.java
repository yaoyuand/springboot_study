package com.study.producer;

import com.study.message.Demo09Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/24 18:09
 */
@Component
public class Demo09Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void synSend(Integer id){
        Demo09Message demo09Message=new Demo09Message();
        demo09Message.setId(id);
        this.rabbitTemplate.convertAndSend(Demo09Message.QUEUE,demo09Message);
    }


}
