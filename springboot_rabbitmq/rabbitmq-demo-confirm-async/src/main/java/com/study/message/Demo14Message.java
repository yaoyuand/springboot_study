package com.study.message;

import java.io.Serializable;

/**
 * @Author ytj
 * @Date 2021/3/25 10:49
 */
public class Demo14Message implements Serializable {
    public static final String QUEUE="QUEUE_DEMO_14";

    public static final String EXCHANGE="EXCHANGE_DEMO_14";

    public static final String ROUTING_KEY="ROUTING_KEY_DEMO_14";

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Demo14Message{" +
                "id=" + id +
                '}';
    }
}
