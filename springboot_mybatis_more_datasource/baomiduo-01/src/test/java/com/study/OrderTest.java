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
 * @Date 2021/3/30 10:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Baomiduo01Application.class)
public class OrderTest {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    @Test
    public void test(){
        Order order=this.orderMapper.selectById(1);
        System.out.println(order);
    }

    @Test
    public void method01(){
        orderService.method01();
    }

    @Test
    public void method02(){
        orderService.method02();
    }

    @Test
    public void method03(){
        orderService.method03();
    }

    @Test
    public void method04(){
        orderService.method04();
    }
}
