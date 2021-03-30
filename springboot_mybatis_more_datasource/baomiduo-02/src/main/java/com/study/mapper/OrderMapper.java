package com.study.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.study.config.DBConstants;
import com.study.entity.Order;
import org.springframework.stereotype.Repository;

/**
 * @Author ytj
 * @Date 2021/3/30 14:43
 */
@Repository
public interface OrderMapper {

    @DS(DBConstants.DATASOURCE_SLAVE)
    Order selectById(Integer id);

    @DS(DBConstants.DATASOURCE_MASTER)
    int insert(Order order);
}
