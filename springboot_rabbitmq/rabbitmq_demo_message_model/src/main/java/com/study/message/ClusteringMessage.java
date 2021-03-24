package com.study.message;

import java.io.Serializable;

/**
 * @Author ytj
 * @Date 2021/3/24 16:29
 */
public class ClusteringMessage implements Serializable {

    public static final String QUEUE = "QUEUE_CLUSTERING";

    public static final String EXCHANGE = "EXCHANGE_CLUSTERING";

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ClusteringMessage{" +
                "id=" + id +
                '}';
    }
}
