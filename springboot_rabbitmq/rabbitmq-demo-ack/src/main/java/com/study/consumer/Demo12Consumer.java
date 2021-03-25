package com.study.consumer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.study.message.Demo12Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * channel.basicAck
 * ack 消息成功确认
 * 第一个参数 表示消息投递序号
 * 第二个参数 multiple ，用于批量确认消息，为了减少网络流量，手动确认可以被批处。
 * 1. 当 multiple 为 true 时，则可以一次性确认 deliveryTag 小于等于传入值的所有消息
 * 2. 当 multiple 为 false 时，则只确认当前 deliveryTag 对应的消息
 * 如果不确认之后就会一直保存在队列中，会重新发送到这个队列中
 * channel.basicNack
 * ack 消息失败确认
 * 第一个参数 表示消息投递序号
 * 第二个参数 是否批量确认
 * 第三个参数 值为 true 消息将重新入队列
 *channel.basicReject
 * ack 消息拒绝确认
 * 第一个参数 表示消息投递序号
 *第二个参数 值为 true 消息将重新入队列
 * @Author ytj
 * @Date 2021/3/25 11:28
 */
@Component
@RabbitListener(queues = Demo12Message.QUEUE)
public class Demo12Consumer {
    private Logger logger= LoggerFactory.getLogger(Demo12Consumer.class);

    @RabbitHandler
    public void onmessage(Demo12Message message, Channel channel,
                          @Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag) throws Exception{
        logger.info("[onmessage][线程编号:{} 消息内容：{}]",Thread.currentThread().getId(),message);
        //提交消费进度
        if(message.getId()%2==1){
            channel.basicAck(deliveryTag,false);
        }else{
            channel.basicNack(deliveryTag,false,true);
        }
    }
}
