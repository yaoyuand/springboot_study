package com.study;

import com.study.entity.Order;
import com.study.mapper.OrderMapper;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author ytj
 * @Date 2021/3/30 16:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DatasourceShardingJdbc2Application.class)
public class OrderMapperTest {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testSelectById() { // 测试从库的负载均衡
        for (int i = 0; i < 10; i++) {
            Order order = orderMapper.selectById(1);
            System.out.println(order);
        }
    }

    /**
     * 测试强制访问主库。在一些业务场景下，对数据延迟敏感，所以只能强制读取主库。
     * 此时，可以使用 HintManager 强制访问主库。
     * 不过要注意，在使用完后，需要去清理下 HintManager （HintManager 是基于线程变量，
     * 透传给 Sharding-JDBC 的内部实现），避免污染下次请求，一直强制访问主库。
     * Sharding-JDBC 比较贴心，HintManager 实现了 AutoCloseable 接口，
     * 可以通过 Try-with-resources 机制，自动关闭。
     * */
    @Test
    public void testSelectById02() { // 测试强制访问主库
        //java1.7之后的Try-with-resources机制自动关闭
        try (HintManager hintManager = HintManager.getInstance()) {
            // 设置强制访问主库
            hintManager.setMasterRouteOnly();
            // 执行查询
            Order order = orderMapper.selectById(1);
            System.out.println(order);
        }
    }

    @Test
    public void testInsert() { // 插入
        Order order = new Order();
        order.setUserId(10);
        orderMapper.insert(order);
    }
}
