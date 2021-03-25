package com.study.message;

import java.io.Serializable;

/**
 * @Author ytj
 * @Date 2021/3/24 14:22
 */
public class Demo15Message implements Serializable {
    public static final String QUEUE = "QUEUE_DEMO_15"; // 正常队列

    public static final String EXCHANGE = "EXCHANGE_DEMO_15";

    public static final String ROUTING_KEY = "ROUTING_KEY_15"; // 正常路由键

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Demo15Message{" +
                "id=" + id +
                '}';
    }
}
