package com.study.producer;

import com.study.message.Demo5Message;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/24 10:23
 */
@Component
public class Demo5Producer {
    @Autowired
    private BatchingRabbitTemplate batchingRabbitTemplate;

    public void synSend(Integer id){
        //创建消息
        Demo5Message demo5Message=new Demo5Message();
        demo5Message.setId(id);
        this.batchingRabbitTemplate.convertAndSend(Demo5Message.EXCHANGE,Demo5Message.ROUTING_KEY,demo5Message);
    }
}
