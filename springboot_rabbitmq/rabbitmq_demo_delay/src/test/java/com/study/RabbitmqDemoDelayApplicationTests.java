package com.study;

import com.study.producer.Demo08Producer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@SpringBootTest(classes = RabbitmqDemoDelayApplication.class)
@RunWith(SpringRunner.class)
class RabbitmqDemoDelayApplicationTests {
    private Logger logger= LoggerFactory.getLogger(RabbitmqDemoDelayApplicationTests.class);

    @Autowired
    private Demo08Producer demo08Producer;

    @Test
    public void testSynsend01() throws Exception{
        this.testsynSend(null);
    }

    @Test
    public void testSynsend02() throws Exception{
        this.testsynSend(3000);
    }

    private void testsynSend(Integer delay) throws Exception{
        int id=(int)(System.currentTimeMillis()/1000);
        this.demo08Producer.synSend(id,delay);
        logger.info("[testsynSend][发送编号:{},发送成功]",id);
        new CountDownLatch(1).await();
    }


}
