package com.study.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.study.entity.Order;
import com.study.config.DBConstants;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author ytj
 * @Date 2021/3/30 10:01
 */
@Repository
@DS(DBConstants.DATASOURCE_ORDERS)
public interface OrderMapper {
    Order selectById(@Param("id")Integer id);
}
