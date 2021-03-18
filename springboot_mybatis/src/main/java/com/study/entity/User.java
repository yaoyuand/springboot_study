package com.study.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ytj
 * @Date 2021/3/10 15:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("user")
public class User {

    @TableId("id")
    private String id;

    @TableField("name")
    private String name;

    @TableField("age")
    private Integer age;

    @TableField("address")
    private String address;
}
