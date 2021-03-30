package com.study.mapper;

import com.study.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author ytj
 * @Date 2021/3/30 10:01
 */
@Repository
public interface OrderMapper {
    Order selectById(@Param("id") Integer id);
}
