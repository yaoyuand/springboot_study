package com.study;

import com.study.entity.Order;
import com.study.entity.User;
import com.study.mapper.OrderMapper;
import com.study.mapper.UserMapper;
import com.study.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author ytj
 * @Date 2021/3/30 15:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DatasourceShardingJdbc01Application.class)
public class OrderTest {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderService orderService;

    @Test
    public void method01(){
        Order order=orderMapper.selectById(1);
        System.out.println(order);
        User user=userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void testMethod01(){
        orderService.method01();
    }

    @Test
    public void testMethod02(){
        orderService.method02();
    }

    @Test
    public void testMethod03(){
        orderService.method03();
    }

    @Test
    public void testMethod04(){
        orderService.method04();
    }

    @Test
    public void testMethod05(){
        orderService.method05();
    }
}
