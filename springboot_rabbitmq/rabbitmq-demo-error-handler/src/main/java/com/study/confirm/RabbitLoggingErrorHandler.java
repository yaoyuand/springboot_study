package com.study.confirm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

/**
 * 在执行顺序上，RabbitListenerErrorHandler 先于 ErrorHandler 执行。
 * 不过这个需要建立在一个前提上，RabbitListenerErrorHandler 需要继续抛出异常
 * @Author ytj
 * @Date 2021/3/25 16:20
 */
@Component
public class RabbitLoggingErrorHandler implements ErrorHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public RabbitLoggingErrorHandler(SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory) {
        rabbitListenerContainerFactory.setErrorHandler(this);
    }
    @Override
    public void handleError(Throwable throwable) {
        logger.error("[handleError][发生异常]]", throwable);
    }
}
