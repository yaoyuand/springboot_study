package com.study;

import com.study.producer.Demo12Producer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqDemoAckApplication.class)
class RabbitmqDemoAckApplicationTests {
    private Logger logger= LoggerFactory.getLogger(RabbitmqDemoAckApplicationTests.class);
    @Autowired
    private Demo12Producer demo12Producer;

    @Test
    public void test() throws Exception{
        for(int i=1;i<=2;i++){
            demo12Producer.synsend(i);
            logger.info("[testSyncSend][发送编号：[{}] 发送成功]", i);
        }
        new CountDownLatch(1).await();
    }

}
