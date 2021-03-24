package com.study;

import com.study.producer.Demo09Producer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@SpringBootTest(classes = RabbitmqDemoConcurrencyApplication.class)
@RunWith(SpringRunner.class)
class RabbitmqDemoConcurrencyApplicationTests {

    private Logger logger= LoggerFactory.getLogger(RabbitmqDemoConcurrencyApplicationTests.class);
    @Autowired
    private Demo09Producer demo09Producer;

    @Test
    public void demo09Test() throws  Exception{
        for(int i=0;i<10;i++) {
            int id = (int) (System.currentTimeMillis() / 1000);
            demo09Producer.synSend(id);
            logger.info("[demo09Test][发送编号:{}.发送成功]", id);
        }
        new CountDownLatch(1).await();
    }

}
