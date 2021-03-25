package com.study.message;

import java.io.Serializable;

/**
 * @Author ytj
 * @Date 2021/3/24 23:09
 */
public class Demo10Message implements Serializable {

    private static final String QUEUE_BASE = "QUEUE_DEMO_10-";
    public static final String QUEUE_0 = QUEUE_BASE + "0";
    public static final String QUEUE_1 = QUEUE_BASE + "1";
    public static final String QUEUE_2 = QUEUE_BASE + "2";
    public static final String QUEUE_3 = QUEUE_BASE + "3";

    public static final int QUEUE_COUNT = 4;

    public static final String EXCHANGE = "EXCHANGE_DEMO_10";

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Demo10Message{" +
                "id=" + id +
                '}';
    }
}
