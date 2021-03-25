package com.study.producer;

import com.study.message.Demo11Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author ytj
 * @Date 2021/3/25 10:57
 */
@Component
public class Demo11Producer {
    private Logger logger= LoggerFactory.getLogger(Demo11Producer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Transactional
    public void synsend(Integer id) throws Exception{
        Demo11Message demo11Message=new Demo11Message();
        demo11Message.setId(id);
        this.rabbitTemplate.convertAndSend(Demo11Message.EXCHANGE,Demo11Message.ROUTING_KEY,demo11Message);
        logger.info("[synsend][发送编号：[{}] 发送成功]",id);
        //线程等待10秒钟，如果消息发送之后立即收到说明事务没有生效，如果10秒钟之后收到说明生效了
        Thread.sleep(10 *1000L);
    }
}
