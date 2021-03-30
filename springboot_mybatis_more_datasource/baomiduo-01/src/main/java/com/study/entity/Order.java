package com.study.entity;

/**
 * @Author ytj
 * @Date 2021/3/29 17:58
 */
public class Order {
    private Integer id;
    /**
     * 用户编号
     */
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
