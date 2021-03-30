package com.study;

import com.study.entity.Order;
import com.study.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author ytj
 * @Date 2021/3/30 17:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DatasourceShardingJdbc2Application.class)
public class OrderServiceTest {
    @Autowired
    private OrderService  orderService;

    @Test
    public void add(){
        Order order=new Order();
        order.setUserId(12);
        order.setId(10);
        orderService.add(order);
    }

    @Test
    public void find(){
        Order order=orderService.findById(1);
        System.out.println(order);
    }
}
