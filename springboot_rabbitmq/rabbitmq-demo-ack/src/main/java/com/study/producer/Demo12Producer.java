package com.study.producer;

import com.study.message.Demo12Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author ytj
 * @Date 2021/3/25 10:57
 */
@Component
public class Demo12Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Transactional
    public void synsend(Integer id) {
        Demo12Message demo11Message=new Demo12Message();
        demo11Message.setId(id);
        this.rabbitTemplate.convertAndSend(Demo12Message.EXCHANGE,Demo12Message.ROUTING_KEY,demo11Message);
    }


}
