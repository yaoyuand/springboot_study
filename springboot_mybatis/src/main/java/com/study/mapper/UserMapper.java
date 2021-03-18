package com.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @Author ytj
 * @Date 2021/3/10 15:55
 */
public interface UserMapper extends BaseMapper<User> {
    List<User> page(Map<String,Object> map);
}
