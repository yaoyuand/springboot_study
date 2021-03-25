package com.study;

import com.study.producer.Demo13Producer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqDemoConfirmApplication.class)
class RabbitmqDemoConfirmApplicationTests {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Demo13Producer producer;

    @Test
    public void testSyncSend() throws Exception {
        int id = (int) (System.currentTimeMillis() / 1000);
        producer.synsend(id);
        logger.info("[synsend][发送编号：[{}] 发送成功]", id);
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

}
