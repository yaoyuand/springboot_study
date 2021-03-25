package com.study.confirm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * 当 Producer 成功发送消息到 RabbitMQ Broker 时，但是在通过 Exchange 进行匹配不到 Queue 时，
 * Broker 会将该消息回退给 Producer
 * @Author ytj
 * @Date 2021/3/25 15:07
 */
@Component
public class RabbitProducerReturnCallback implements RabbitTemplate.ReturnsCallback {
    private Logger logger = LoggerFactory.getLogger(getClass());


    public RabbitProducerReturnCallback(RabbitTemplate rabbitTemplate) {
        rabbitTemplate.setReturnsCallback(this);
    }

    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        logger.error("[returnedMessage][message: [{}] replyCode: [{}] replyText: [{}] exchange: [{}] routingKey: [{}]]",
                returnedMessage.getMessage(), returnedMessage.getReplyCode(), returnedMessage.getReplyText(), returnedMessage.getExchange(), returnedMessage.getRoutingKey());
    }
}
