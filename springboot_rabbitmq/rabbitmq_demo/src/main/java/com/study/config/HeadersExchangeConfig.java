package com.study.config;

import com.study.message.Demo4Message;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * Headers Exchange 不依赖于 routing key 与 binding key 的匹配规则来路由消息，
 * 而是根据发送的消息内容中的 headers 属性进行匹配。
 * (Headers Exchange 性能很差，实际场景也使用比较少,正常不使用)
 * @Author ytj
 * @Date 2021/3/23 17:57
 */
@Component
public class HeadersExchangeConfig {
    @Bean
    public Queue demo04Queue(){
        return new Queue(Demo4Message.QUEUE,
                true,
                false,
                false);
    }

    @Bean
    public HeadersExchange demo04Exchange(){
        return new HeadersExchange(Demo4Message.EXCHANGE,true,false);
    }

    @Bean
    public Binding demo04Binding(){
        return BindingBuilder.bind(demo04Queue()).to(demo04Exchange()).where(Demo4Message.HEARD_KEY).matches(Demo4Message.HEARD_VALUE);
    }
}
