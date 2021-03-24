package com.study.message;

import java.io.Serializable;

/**
 * @Author ytj
 * @Date 2021/3/22 15:54
 */
public class Demo1Message implements Serializable {
    public static final String QUEUE="QUEUE_DEMO_01";

    public static final String EXCHANGE="EXCHANGE_DEMO_01";

    public static final String ROUTING_KEY="ROUTING_KEY_01";

    private Integer id;

    public Integer getId() {
        return id;
    }

    public Demo1Message setId(Integer id) {
        this.id = id;
        return this;
    }

    public String toString(){
        return "id:"+id;
    }
}
