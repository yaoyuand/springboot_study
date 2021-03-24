package com.study.message;

import java.io.Serializable;

/**
 * @Author ytj
 * @Date 2021/3/23 17:22
 */
public class Demo03Message implements Serializable {
    public static final String QUEUE_A="QUEUE_A_DEMO_03";

    public static final String QUEUE_B="QUEUE_B_DEMO_03";

    public static final String EXCHANGE="EXCHANGE_DEMO_03";

    public Integer id;

    public Integer getId() {
        return id;
    }

    public Demo03Message setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "Demo03Message{" +
                "id=" + id +
                '}';
    }
}
