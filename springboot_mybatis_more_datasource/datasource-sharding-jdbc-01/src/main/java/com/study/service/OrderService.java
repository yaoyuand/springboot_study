package com.study.service;

import com.study.entity.Order;
import com.study.entity.User;
import com.study.mapper.OrderMapper;
import com.study.mapper.UserMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author ytj
 * @Date 2021/3/30 11:20
 */
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 通过 AopContext 获得自己这个代理对象
     * 举个例子，在 #method01() 方法中，如果直接使用 this.method02() 方法进行调用，
     * 因为 this 代表的是 OrderService Bean 自身，而不是其 AOP 代理对象。这样会导致，
     * 无法触发 AOP 的逻辑，在此处，就是 Spring 事务的逻辑。因此，我们通过 AopContext
     * 获得自己这个代理对象
     * */
    private OrderService self() {
        return (OrderService) AopContext.currentProxy();
    }

    public void method01(){
        Order order=orderMapper.selectById(1);
        System.out.println(order);
        User user=userMapper.selectById(1);
        System.out.println(user);
    }


    @Transactional
    public void method02(){
        Order order=orderMapper.selectById(1);
        System.out.println(order);
        User user=userMapper.selectById(1);
        System.out.println(user);
    }


    public void method03(){
        self().method031();
        self().method032();
    }


    @Transactional
    public void method031(){
        Order order=orderMapper.selectById(1);
        System.out.println(order);
    }

    @Transactional
    public void  method032(){
        User user=userMapper.selectById(1);
        System.out.println(user);
    }


    public void method04(){
        self().method041();
        self().method042();
    }

    @Transactional
    public void method041(){
        Order order=orderMapper.selectById(1);
        System.out.println(order);
    }

    @Transactional
    public void method042(){
        User user=userMapper.selectById(1);
        System.out.println(user);
    }

    @Transactional
    public void method05() {
        // 查询订单
        Order order = orderMapper.selectById(1);
        System.out.println(order);
        // 查询用户
        self().method052();
    }



    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void method052() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }


}
