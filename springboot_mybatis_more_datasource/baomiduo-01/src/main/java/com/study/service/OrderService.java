package com.study.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.study.config.DBConstants;
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

    /**
     * 这边查询会报错 (Table 'test_users.orders' doesn't exist)
     *原因为:spring添加Transactional注解之后，事务会生效，通过AOP拦截该方法创建事务，创建事务的时候肯定会获取数据源
     * TransactionInterceptor 会使用 Spring DataSourceTransactionManager 创建事务，
     *
     * 并将事务信息通过 ThreadLocal 绑定在当前线程。事务信息中包含connection连接在没有
     * 进行orderMapper查询操作时就已经创建出来了。所以会报错
     *
     * 在使用dynamic-datasource-spring-boot-starter时,它创建了一个DynamicRoutingDataSource,传入到DataSourceTransactionManager
     * DynamicRoutingDataSource 需要基于 @DS 获得数据源名从而获得对应的 DataSource ，
     * 结果因为我们在 Service 方法上，并没有添加 @DS 注解，所以它只好返回默认数据源，也就是 users
     * */
    @Transactional
    public void method02(){
        Order order=orderMapper.selectById(1);
        System.out.println(order);
        User user=userMapper.selectById(1);
        System.out.println(user);
    }

    /**
     * 如果使用self()方式调用method031会报错，原因同上面的原因相同
     * 但是如果将self()换成为this就不会报错，主要原因是因为this不是代理对象，Transactional注解不起作用了。
     * 就同场景一类似了。
     * */
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

    /**
     * 这边能够正常执行，因为有Transactional注解，所以会触发spring事务机制
     * DynamicRoutingDataSource 根据 @DS 注解，获得对应的 orders 的 DataSource ，
     * 从而获得 Connection 。所以后续 OrderMapper 执行查询操作时，即使使用的是线程绑定的 Connection ，
     * 也可能不会报错。😈 嘿嘿，实际上，此时 OrderMapper 上的 @DS 注解，也没有作用。
     * */
    public void method04(){
        self().method041();
        self().method042();
    }

    @Transactional
    @DS(DBConstants.DATASOURCE_ORDERS)
    public void method041(){
        Order order=orderMapper.selectById(1);
        System.out.println(order);
    }

    @Transactional
    @DS(DBConstants.DATASOURCE_USERS)
    public void method042(){
        User user=userMapper.selectById(1);
        System.out.println(user);
    }

    @Transactional
    @DS(DBConstants.DATASOURCE_ORDERS)
    public void method05() {
        // 查询订单
        Order order = orderMapper.selectById(1);
        System.out.println(order);
        // 查询用户
        self().method052();
    }


    /**
     * 我们添加的 @Transactionl 注解，使用的事务传播级别是 Propagation.REQUIRES_NEW 。
     * 此时，在执行 #method052() 方法之前，TransactionInterceptor 会将原事务挂起，
     * 暂时性的将原事务信息和当前线程解绑。
     * 所以，在执行 #method052() 方法前，又可以执行一轮事务的逻辑。
     * 之后，在执行 #method052() 方法完成后，会将原事务恢复，重新将原事务信息和当前线程绑定。
     * */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @DS(DBConstants.DATASOURCE_USERS)
    public void method052() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }


}
