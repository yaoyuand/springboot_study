package com.study;

import com.study.entity.Order;
import com.study.mapper.OrderMapper;
import com.study.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author ytj
 * @Date 2021/3/30 14:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Baomiduo02Application.class)
public class OrderTest {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    /**
     * 两个从库的数据会循环输出,代表实现了负载均衡
     * */
    @Test
    public void testSelectById(){
        for(int i=0;i<10;i++){
            Order order=orderMapper.selectById(1);
            System.out.println(order);
        }
    }

    @Test
    public void testInsert(){
        Order order=new Order();
        order.setUserId(10);
        orderMapper.insert(order);
    }

    @Test
    public void testAdd(){
        Order order=new Order();
        order.setId(11);
        order.setUserId(10);
        orderService.add(order);
    }

    @Test
    public void testFind(){
        orderService.findById(1);
    }
}
