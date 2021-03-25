package com.study;

import com.study.producer.Demo11Producer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqDemoTransactionApplication.class)
class RabbitmqDemoTransactionApplicationTests {
    private Logger logger= LoggerFactory.getLogger(RabbitmqDemoTransactionApplicationTests.class);
    @Autowired
    private Demo11Producer demo11Producer;

    @Test
    public void test() throws Exception{
        int id=(int)(System.currentTimeMillis()/1000);
        demo11Producer.synsend(id);
        logger.info("[test][发送消息:{},发送成功]",id);
        new CountDownLatch(1).await();
    }

}
