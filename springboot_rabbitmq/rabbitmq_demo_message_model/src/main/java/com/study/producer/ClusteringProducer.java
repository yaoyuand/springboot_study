package com.study.producer;

import com.study.message.ClusteringMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author ytj
 * @Date 2021/3/24 16:48
 */
@Component
public class ClusteringProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void synSend(Integer id){
        ClusteringMessage clusteringMessage=new ClusteringMessage();
        clusteringMessage.setId(id);
        //同步发送消息
        this.rabbitTemplate.convertAndSend(ClusteringMessage.EXCHANGE,null,clusteringMessage);
    }
}
