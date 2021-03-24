package com.study.message;

import java.io.Serializable;

/**
 * @Author ytj
 * @Date 2021/3/24 18:04
 */
public class Demo09Message implements Serializable {
    public static final String QUEUE="QUEUE_DEMO_09";

    public static final String EXCHANGE="EXCHANGE_DEMO_09";

    public static final String ROUTING_KEY="ROUTING_KEY_DEMO_09";

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Demo09Message{" +
                "id=" + id +
                '}';
    }
}
