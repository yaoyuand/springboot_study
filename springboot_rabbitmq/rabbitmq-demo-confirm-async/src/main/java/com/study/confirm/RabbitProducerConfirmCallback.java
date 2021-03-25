package com.study.confirm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * 实现异步的 Confirm 模式
 * 提供 Producer 收到 RabbitMQ 确认消息的“响应”的回调
 * @Author ytj
 * @Date 2021/3/25 14:48
 */
@Component
public class RabbitProducerConfirmCallback implements RabbitTemplate.ConfirmCallback {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public RabbitProducerConfirmCallback(RabbitTemplate rabbitTemplate) {
        rabbitTemplate.setConfirmCallback(this);
    }
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            logger.info("[confirm][Confirm 成功 correlationData: {}]", correlationData);
        } else {
            logger.error("[confirm][Confirm 失败 correlationData: {} cause: {}]", correlationData, cause);
        }
    }
}
