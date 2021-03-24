package com.study;

import com.study.producer.Demo07Producer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@SpringBootTest(classes = RabbitmqConsumerRetryApplication.class)
@RunWith(SpringRunner.class)
class RabbitmqConsumerRetryApplicationTests {
    private Logger logger= LoggerFactory.getLogger(RabbitmqConsumerRetryApplicationTests.class);
    @Autowired
    private Demo07Producer demo07Producer;

    @Test
    public void testDemo07() throws Exception{
        int id=(int)(System.currentTimeMillis()/1000);
        this.demo07Producer.synSend(id);
        logger.info("[testDemo07][发送消息:{},发送成功]",id);
        new CountDownLatch(1).await();
    }

}
