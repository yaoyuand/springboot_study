package com.study.service;

import com.study.entity.Order;
import com.study.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author ytj
 * @Date 2021/3/30 14:57
 */
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    public void add(Order order){
        //这边查询一下
        orderMapper.selectById(order.getId());
        //插入订单
        orderMapper.insert(order);
    }

    public Order findById(Integer id){
        return orderMapper.selectById(id);
    }
}
