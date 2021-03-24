package com.study.message;

import java.io.Serializable;

/**
 * @Author ytj
 * @Date 2021/3/24 17:10
 */
public class BroadcastMessage implements Serializable {
    public static final String QUEUE = "QUEUE_BROADCASTING";

    public static final String EXCHANGE = "EXCHANGE_BROADCASTING";

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BroadcastMessage{" +
                "id=" + id +
                '}';
    }
}
