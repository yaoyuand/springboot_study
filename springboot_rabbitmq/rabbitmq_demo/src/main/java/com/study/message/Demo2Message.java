package com.study.message;

import java.io.Serializable;

/**
 * @Author ytj
 * @Date 2021/3/23 16:46
 */
public class Demo2Message implements Serializable {
    public static final String QUEUE="QUEUE_DEMO_02";

    public static final String EXCHANGE="EXCHANGE_DEMO_02";

    public static final String ROUTING_KEY="#.study.test";

    private Integer id;

    public Integer getId() {
        return id;
    }

    public Demo2Message setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "Demo2Message{" +
                "id=" + id +
                '}';
    }
}
