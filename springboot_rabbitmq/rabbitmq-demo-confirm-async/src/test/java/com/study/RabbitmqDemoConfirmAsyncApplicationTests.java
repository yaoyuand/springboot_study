package com.study;

import com.study.producer.Demo14Producer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqDemoConfirmAsyncApplication.class)
class RabbitmqDemoConfirmAsyncApplicationTests {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Demo14Producer demo14Producer;

    @Test
    public void test() throws Exception{
        int id=(int)(System.currentTimeMillis()/1000);
        this.demo14Producer.synsend(id);
        logger.info("[test][发送编号：[{}] 发送成功]", id);
        new CountDownLatch(1).await();
    }

    @Test
    public void tests() throws Exception{
        int id=(int)(System.currentTimeMillis()/1000);
        this.demo14Producer.synsends(id);
        logger.info("[tests][发送编号：[{}] 发送成功]", id);
        new CountDownLatch(1).await();
    }

}
