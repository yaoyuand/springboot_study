package com.study.message;

import java.io.Serializable;

/**
 * @Author ytj
 * @Date 2021/3/23 18:13
 */
public class Demo4Message implements Serializable {
    public static final String QUEUE="QUEUE_DEMO_04";

    public static final String EXCHANGE="EXCHANGE_DEMO_04";

    public static final String HEARD_KEY="color";

    public static final String HEARD_VALUE="red";

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Demo4Message{" +
                "id=" + id +
                '}';
    }
}
