package com.study.message;

import java.io.Serializable;

/**
 * @Author ytj
 * @Date 2021/3/24 10:09
 */
public class Demo5Message implements Serializable {
    public static final String QUEUE="QUEUE_DEMO_5";

    public static final String EXCHANGE="EXCHANGE_DEMO_5";

    public static final String ROUTING_KEY="ROUTING_KEY_5";

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Demo5Message{" +
                "id=" + id +
                '}';
    }
}
