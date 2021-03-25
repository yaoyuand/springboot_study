package com.study.producer;

import com.rabbitmq.client.ConfirmCallback;
import com.study.message.Demo13Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitOperations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @Author ytj
 * @Date 2021/3/25 10:57
 */
@Component
public class Demo13Producer {
    private Logger logger= LoggerFactory.getLogger(Demo13Producer.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void synsend(Integer id) {
        Demo13Message demo13Message=new Demo13Message();
        demo13Message.setId(id);
        /**
         * 同步发送消息
         * 在方法参数 action 中，我们可以自定义操作。
         * 在方法参数 acks 中，定义接收到 RabbitMQ Broker 的成功“响应”时的成回调。
         * 在方法参数 nacks 中，定义接收到 RabbitMQ Broker 的失败“响应”时的成回调
         * */
        rabbitTemplate.invoke(new RabbitOperations.OperationsCallback<Object>() {
              @Override
              public Object doInRabbit(RabbitOperations rabbitOperations) {
                  rabbitOperations.convertAndSend(Demo13Message.EXCHANGE, Demo13Message.ROUTING_KEY, demo13Message);
                  logger.info("[doInRabbit][发送消息完成]");
                  //等待确认
                  rabbitOperations.waitForConfirms(0);// timeout 参数，如果传递 0 ，表示无限等待
                  logger.info("[doInRabbit][等待 Confirm 完成]");
                  return null;
              }
          }, new ConfirmCallback() {
              @Override
              public void handle(long deliveryTag, boolean multiple) throws IOException {
                  logger.info("[handle][Confirm 成功]");
              }
          }, new ConfirmCallback() {
              @Override
              public void handle(long l, boolean b) throws IOException {
                  logger.info("[handle][Confirm 失败]");
              }
          });
    }
}
