package com.study.mapper;

import com.study.entity.Order;
import org.springframework.stereotype.Repository;

/**
 * @Author ytj
 * @Date 2021/3/30 10:01
 */
@Repository
public interface OrderMapper {
    Order selectById(Integer id);

    int insert(Order order);
}
