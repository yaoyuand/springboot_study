package com.study.message;

import java.io.Serializable;

/**
 * @Author ytj
 * @Date 2021/3/25 10:49
 */
public class Demo11Message implements Serializable {
    public static final String QUEUE="QUEUE_DEMO_11";

    public static final String EXCHANGE="EXCHANGE_DEMO_11";

    public static final String ROUTING_KEY="ROUTING_KEY_DEMO_11";

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Demo11Message{" +
                "id=" + id +
                '}';
    }
}
