package com.study.config;

import com.study.message.Demo2Message;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Topic Exchange和Direct Exchange有点相似，但是匹配规则不相同
 * binding key 中可以存在两种特殊字符 "*" 与 "#"，用于做模糊匹配。
 * 其中 "*" 用于匹配一个单词，"#" 用于匹配多个单词（可以是零个）。
 * @Author ytj
 * @Date 2021/3/23 16:49
 */
@Configuration
public class TopicExchangeConfig {
    @Bean
    public Queue demo02Queue(){
        return new Queue(Demo2Message.QUEUE,//queue名称
                true,//是否持久化
                false,//是否排他
                false);//是否自动删除
    }

    @Bean
    public TopicExchange demo02Exchange(){
        return new TopicExchange(Demo2Message.EXCHANGE,//exchange名称
                true,//是否持久化
                false);//是否自动删除
    }

    @Bean
    public Binding demo02Binding(){
        return BindingBuilder.bind(demo02Queue()).to(demo02Exchange()).with(Demo2Message.ROUTING_KEY);
    }
}
