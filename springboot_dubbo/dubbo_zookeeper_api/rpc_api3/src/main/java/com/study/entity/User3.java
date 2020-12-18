package com.study.entity;

import java.io.Serializable;

public class User3 implements Serializable {
    private static final long serialVersionUID = -4173182440321198350L;
    private Integer age;

    private String name;

    private String address;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User3(Integer age, String name, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }
}
