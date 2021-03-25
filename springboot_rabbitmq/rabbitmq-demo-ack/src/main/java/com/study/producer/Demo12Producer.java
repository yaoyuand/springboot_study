package com.study.producer;

import com.study.consumer.Demo12Consumer;
import com.study.message.Demo12Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author ytj
 * @Date 2021/3/25 10:57
 */
@Component
public class Demo12Producer implements RabbitTemplate.ConfirmCallback{
    private Logger logger= LoggerFactory.getLogger(getClass());
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Transactional
    public void synsend(Integer id) {
        Demo12Message demo11Message=new Demo12Message();
        demo11Message.setId(id);
        this.rabbitTemplate.convertAndSend(Demo12Message.EXCHANGE,Demo12Message.ROUTING_KEY,demo11Message);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        logger.info("消息id:" + correlationData.getId());
        if (b) {
            logger.info("消息发送确认成功");
        } else {
            logger.info("消息发送确认失败:" + s);
        }
    }
}
