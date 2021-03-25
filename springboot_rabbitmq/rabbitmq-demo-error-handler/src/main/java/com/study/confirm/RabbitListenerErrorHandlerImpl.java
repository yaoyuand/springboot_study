package com.study.confirm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.RabbitListenerErrorHandler;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;
import org.springframework.stereotype.Component;

/**
 * 要注意，如果此时我们不继续抛出异常，而是 return 结果，意味着 Consumer 消息成功
 * @Author ytj
 * @Date 2021/3/25 16:18
 */
@Component("rabbitListenerErrorHandler")
public class RabbitListenerErrorHandlerImpl implements RabbitListenerErrorHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Object handleError(Message message, org.springframework.messaging.Message<?> message1,
                              ListenerExecutionFailedException exception)  {
        // 打印异常日志
        logger.error("[handleError][amqpMessage:[{}] message:[{}]]", message, message1, exception);

        // 直接继续抛出异常
        throw exception;
    }
}
